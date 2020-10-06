package shipment.tracking.transformer;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import shipment.tracking.transformer.xml.TrackingXmlConversionResult;

import java.util.Map.Entry;
import java.util.Properties;

import static java.util.stream.Collectors.toMap;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;

public class ShipmentXMLFilteringStreamsApp {

  public static void main(String[] args) {
    // configs
    final var config = ConfigFactory.load();
    final var bootstrapServers = config.getString("kafka.bootstrap.servers");
    var clientConfig = config.getConfig("kafka.client").entrySet().stream()
        .collect(toMap(Entry::getKey, entry -> entry.getValue().unwrapped()));

    // build stream application
    final var builder = new StreamsBuilder();

    // parse incoming xml array into individual elements
    createTopology(config, builder);

    // run streams application

    final var streamsConfig = new Properties();
    streamsConfig.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    streamsConfig.putAll(clientConfig);

    final var topology = builder.build();
    final var streams = new KafkaStreams(topology, streamsConfig);
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    streams.start();
  }

   public static void createTopology(Config config, StreamsBuilder builder) {
       KStream<String, String> inputStream = builder.stream(config.getString("kafka.client.source.topic"),
               Consumed.with(Serdes.String(), Serdes.String()));

       

       KStream<String, TrackingXmlConversionResult>[] branches = inputStream
               .mapValues(Transformer::parseXml)
               .branch(
                       (k, v) -> v.getTracking() != null && v.getTracking().getHawbNumber() != null,
                       (k, v) -> true
               );

     KStream<String, TrackingXmlConversionResult> xmlStructureStream = branches[0];
     KStream<String, TrackingXmlConversionResult> xmlParsingErrorsStream = branches[1];

     xmlParsingErrorsStream.mapValues(v -> TrackingXmlConversionResult.mapToJsonString(v.getErrorInfo()))
             .to(config.getString("kafka.client.errors.topic"), Produced.with(Serdes.String(),
                     Serdes.String()));

     xmlStructureStream.mapValues(Transformer::convertToJson)
             .filter((k, v) -> v != null)
             .to(config.getString("kafka.client.destination.topic"), Produced.with(Serdes.String(),
                     Serdes.String()));
  }
}
