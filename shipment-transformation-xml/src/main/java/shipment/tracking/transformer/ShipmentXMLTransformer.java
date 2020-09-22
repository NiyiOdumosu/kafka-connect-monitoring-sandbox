package shipment.tracking.transformer;

import static java.util.stream.Collectors.toMap;
import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;

import com.typesafe.config.ConfigFactory;
import java.util.Map.Entry;
import java.util.Properties;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import shipment.tracking.transformer.xml.Tracking;

public class ShipmentXMLTransformer {

  public static void main(String[] args) {
    // configs
    final var config = ConfigFactory.load();
    final var bootstrapServers = config.getString("kafka.bootstrap.servers");
    var clientConfig = config.getConfig("kafka.client").entrySet().stream()
        .collect(toMap(Entry::getKey, entry -> entry.getValue().unwrapped()));

    // build stream application
    final var builder = new StreamsBuilder();

    // parse incoming xml array into individual elements
    KStream<String, Tracking> xmlStream = builder.stream(config.getString("kafka.client.source.topic"), Consumed.with(Serdes.String(), Serdes.String()))
            .mapValues(Transformer::parseXml);

    xmlStream.mapValues(Transformer::convertToJson)
            .to(config.getString("kafka.client.destination.topic"), Produced.with(Serdes.String(), Serdes.String()));

    // run streams application

    final var streamsConfig = new Properties();
    streamsConfig.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    streamsConfig.putAll(clientConfig);

    final var topology = builder.build();
    final var streams = new KafkaStreams(topology, streamsConfig);
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    streams.start();
  }
}
