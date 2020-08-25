package poc.adapter;

import static java.util.stream.Collectors.toMap;
import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;

import com.typesafe.config.ConfigFactory;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;

public class Main {

  public static void main(String[] args) {
    // configs
    final var config = ConfigFactory.load();
    final var bootstrapServers = config.getString("kafka.bootstrap-servers");
    var clientConfig = config.getConfig("kafka.client").entrySet().stream()
        .collect(toMap(Entry::getKey, entry -> entry.getValue().unwrapped()));
    var srConfig = config.getConfig("kafka.schema-registry").entrySet().stream()
        .collect(toMap(Entry::getKey, entry -> entry.getValue().unwrapped().toString()));

    // build stream application
    final var builder = new StreamsBuilder();
    // parse incoming xml array into individual elements
    final var inputStream =
        builder.stream("aramex.poc.input", Consumed.with(Serdes.String(), Serdes.String()))
            .mapValues(Adapter::parseXml)
            .flatMapValues(v -> v.books);
    // to plain json
    inputStream
        .map((k, v) -> KeyValue.pair(v.id, Adapter.toJson(v)))
        .mapValues(Adapter::toJsonString)
        .to("aramex.poc.input-json", Produced.with(Serdes.String(), Serdes.String()));

    // schema registry config
    final var schemaRegistryConfig = new HashMap<>(srConfig);

    // to json-schema based output
    final var jsonSchemaSerde = new KafkaJsonSchemaSerde<poc.adapter.json.Book>();
    jsonSchemaSerde.configure(schemaRegistryConfig, false);

    inputStream
        .map((k, v) -> KeyValue.pair(v.id, Adapter.toJson(v)))
        .to("aramex.poc.input-json-schema", Produced.with(Serdes.String(), jsonSchemaSerde));
    // to avro-schema based output
    final var avroSchemaSerde = new GenericAvroSerde();
    avroSchemaSerde.configure(schemaRegistryConfig, false);

    inputStream
        .map((k, v) -> KeyValue.pair(v.id, Adapter.toAvro(v)))
        .to("aramex.poc.input-avro", Produced.with(Serdes.String(), avroSchemaSerde));

    // run streams application

    final var streamsConfig = new Properties();
    streamsConfig.put(APPLICATION_ID_CONFIG, "aramex-poc-adapter");
    streamsConfig.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    streamsConfig.putAll(clientConfig);

    final var topology = builder.build();
    final var streams = new KafkaStreams(topology, streamsConfig);
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    streams.start();
  }
}
