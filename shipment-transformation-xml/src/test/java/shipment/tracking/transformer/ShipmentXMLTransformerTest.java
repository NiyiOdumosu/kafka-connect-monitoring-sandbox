package shipment.tracking.transformer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import junit.framework.TestCase;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static org.apache.kafka.common.utils.Utils.*;
import static org.apache.kafka.common.utils.Utils.mkEntry;
import static org.assertj.core.api.Assertions.assertThat;

public class ShipmentXMLTransformerTest {
    private TestInputTopic<String, String> inputTopic;
    private TestOutputTopic<String, String> outputTopic;
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
            mkEntry("kafka.client.destination.topic", "aramex.poc.output")) // disable for debugging
    );

    @Before
    public void setUp() {
        Config config = ConfigFactory.parseProperties(ShipmentXMLTransformerTest.config);
        StreamsBuilder builder = new StreamsBuilder();
        ShipmentXMLTransformer.createTopology(config, builder);

        testDriver = new TopologyTestDriver(builder.build(), ShipmentXMLTransformerTest.config);

        inputTopic = testDriver.createInputTopic("aramex.poc.input", Serdes.String().serializer(), Serdes.String().serializer());
        outputTopic = testDriver.createOutputTopic("aramex.poc.output", Serdes.String().deserializer(), Serdes.String().deserializer());
    }

    @Test
    public void when_EmptyStringInput_Then_NoOutput() {
        inputTopic.pipeInput("");

        assertThat(outputTopic.isEmpty());
    }

    @Test
    public void when_InvalidXML_Then_PrintExceptionAndProceed() {
        inputTopic.pipeInput("<TAG>");

        assertThat(outputTopic.isEmpty());
    }

    @Test
    public void when_ValidXMLWrongSchema_Then_NoOutput() {
        inputTopic.pipeInput("<TAG></TAG>");

        assertThat(outputTopic.isEmpty());
    }

    @SneakyThrows
    @Test
    public void when_ValidXMLCorrectSchema_Then_JsonOutput() {
        var xmlPath = "src/test/resources/tracking-activity.xml";
        var xml = Files.readString(Paths.get(xmlPath));
        inputTopic.pipeInput(xml);

        String jsonOut = outputTopic.readValue();

        var jsonPath = "src/test/resources/tracking-activity.json";
        var expectedJson = Files.readString(Paths.get(jsonPath)).replace("\n", "");

        ObjectMapper mapper = new ObjectMapper();

        assertThat(mapper.readTree(jsonOut)).isEqualTo(mapper.readTree(expectedJson));

    }

    @SneakyThrows
    @Test
    public void when_InvalidXMLEmbedCorrectSchema_Then_NoOutput() {
        var xmlPath = "src/test/resources/tracking-activity-invalid-embed.xml";
        var xml = Files.readString(Paths.get(xmlPath));
        inputTopic.pipeInput(xml);

        assertThat(outputTopic.isEmpty());
    }
}
