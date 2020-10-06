package shipment.tracking.transformer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import static org.apache.kafka.common.utils.Utils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ShipmentXMLFilteringStreamsAppTest {
    private TestInputTopic<String, String> inputTopic;
    private TestOutputTopic<String, String> outputTopic;
    private TestOutputTopic<String, String> errorsTopic;
    private TopologyTestDriver testDriver;

    public static final Properties config = mkProperties(mkMap(
            mkEntry(StreamsConfig.APPLICATION_ID_CONFIG, "TestTopicsTest-" + Math.random()),
            mkEntry(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234"),
            mkEntry(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, "exactly_once"),
//            mkEntry(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "mock://sr"),
            mkEntry(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName()),
            mkEntry(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName()),
            mkEntry(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, "0"), // disable for debugging
            mkEntry("kafka.client.source.topic", "aramex.poc.input"),
            mkEntry("kafka.client.destination.topic", "aramex.poc.output"), // disable for debugging
            mkEntry("kafka.client.errors.topic", "aramex.poc.errors")) // disable for debugging
    );

    @Before
    public void setUp() {
        Config config = ConfigFactory.parseProperties(ShipmentXMLFilteringStreamsAppTest.config);
        StreamsBuilder builder = new StreamsBuilder();
        ShipmentXMLFilteringStreamsApp.createTopology(config, builder);

        testDriver = new TopologyTestDriver(builder.build(), ShipmentXMLFilteringStreamsAppTest.config);

        inputTopic = testDriver.createInputTopic("aramex.poc.input", Serdes.String().serializer(), Serdes.String().serializer());
        outputTopic = testDriver.createOutputTopic("aramex.poc.output", Serdes.String().deserializer(), Serdes.String().deserializer());
        errorsTopic = testDriver.createOutputTopic("aramex.poc.errors", Serdes.String().deserializer(), Serdes.String().deserializer());
    }

    @Test
    public void when_EmptyStringInput_Then_WriteToErrorsTopic() {
        inputTopic.pipeInput("");

        assertThat(outputTopic.readValuesToList()).isEmpty();
        assertThat(errorsTopic.readValuesToList()).isNotEmpty();
    }

    @Test
    public void when_InvalidXml_Then_WriteToErrorsTopic() {
        inputTopic.pipeInput("<TAG>");

        assertThat(outputTopic.readValuesToList()).isEmpty();
        assertThat(errorsTopic.readValuesToList()).isNotEmpty();
    }

    @Test
    public void when_ValidXmlWrongSchema_Then_WriteToErrorsTopic() {
        inputTopic.pipeInput("<TAG></TAG>");

        assertThat(outputTopic.readValuesToList()).isEmpty();
        assertThat(errorsTopic.readValuesToList()).isNotEmpty();
    }

    @SneakyThrows
    @Test
    public void when_ValidXmlCorrectSchema_Then_JsonOutput() {
        var xmlPath = "src/test/resources/tracking-activity.xml";
        var xml = Files.readString(Paths.get(xmlPath));
        inputTopic.pipeInput(xml);

        String jsonOut = outputTopic.readValue();

        var jsonPath = "src/test/resources/tracking-activity.json";
        var expectedJson = Files.readString(Paths.get(jsonPath)).replace("\n", "");

        ObjectMapper mapper = new ObjectMapper();

        assertThat(mapper.readTree(jsonOut)).isEqualTo(mapper.readTree(expectedJson));
        assertThat(errorsTopic.readValuesToList()).isEmpty();
    }

    @SneakyThrows
    @Test
    public void when_ValidXmlAdditionalProps_Then_JsonOutput() {
        var xmlPath = "src/test/resources/tracking-activity-additional-props.xml";
        var xml = Files.readString(Paths.get(xmlPath));
        inputTopic.pipeInput(xml);

        String jsonOut = outputTopic.readValue();

        assertThat(jsonOut).isNotBlank();
        assertThat(errorsTopic.readValuesToList()).isEmpty();
    }

    @SneakyThrows
    @Test
    public void when_ValidXmlAdditionalProps_Then_AdditionalPropertiesAreAccessible() {
        var xmlPath = "src/test/resources/tracking-activity-additional-props.xml";
        var xml = Files.readString(Paths.get(xmlPath));

        inputTopic.pipeInput(xml);

        List<String> strings = outputTopic.readValuesToList();

        assertThat(strings).hasSize(1);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actual = mapper.readTree(strings.get(0))
                .get("hawbDetails")
                .get("additionalProperties")
                .get("ShipmentProfile");

        assertThat(actual).isNotNull();
        assertThat(errorsTopic.readValuesToList()).isEmpty();
    }

    @SneakyThrows
    @Test
    public void when_InvalidXmlEmbedCorrectSchema_Then_WriteToErrorsTopic() {
        var xmlPath = "src/test/resources/tracking-activity-invalid-embed.xml";
        var xml = Files.readString(Paths.get(xmlPath));
        inputTopic.pipeInput(xml);

        List<String> output = outputTopic.readValuesToList();
        assertThat(output).isEmpty();

        List<String> errors = errorsTopic.readValuesToList();
        assertThat(errors).isNotEmpty();
    }

    @SneakyThrows
    @Test
    public void when_EmbeddedXmlIsEmpty_Then_ProduceJsonWithoutDim() {
        var xmlPath = "src/test/resources/tracking-activity-no-hawdbimensions.xml";
        var xml = Files.readString(Paths.get(xmlPath));
        inputTopic.pipeInput(xml);

        assertThat(outputTopic.readValuesToList()).isNotEmpty();
        assertThat(errorsTopic.readValuesToList()).isEmpty();
    }
}
