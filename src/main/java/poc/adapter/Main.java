package poc.adapter;

import com.typesafe.config.ConfigFactory;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Properties;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import poc.adapter.json.Book;
import poc.adapter.xml.Catalog;

public class Main {

  static JAXBContext context;

  static final String bookAvroSchema = "{"
      + "\"type\": \"record\","
      + "\"name\": \"book\","
      + "\"namespace\": \"poc.adapter.avro\","
      + "\"fields\": ["
      + "{\"name\": \"id\",\"type\": \"string\"},"
      + "{\"name\": \"title\",\"type\": \"string\"},"
      + "{\"name\": \"author\",\"type\": \"string\"},"
      + "{\"name\": \"genre\",\"type\": \"string\"},"
      + "{\"name\": \"price\",\"type\": \"double\"},"
      + "{\"name\": \"publishDate\",\"type\": \"string\"},"
      + "{\"name\": \"description\",\"type\": \"string\"}"
      + "]"
      + "}";
  static final Schema.Parser parser = new Schema.Parser();
  static final Schema schema = parser.parse(bookAvroSchema);

  public static void main(String[] args) {
    try {
      context = JAXBContext.newInstance(Catalog.class);
    } catch (JAXBException e) {
      e.printStackTrace();
    }

    final var config = ConfigFactory.load();

    final var builder = new StreamsBuilder();
    final var inputStream =
        builder.stream("input", Consumed.with(Serdes.String(), Serdes.String()))
            .mapValues(Main::parseXml)
            .flatMapValues(v -> v.books);

    final var schemaRegistryConfig = new HashMap<String, String>();
    schemaRegistryConfig
        .put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

    final var jsonSchemaSerde = new KafkaJsonSchemaSerde<poc.adapter.json.Book>();
    jsonSchemaSerde.configure(schemaRegistryConfig, false);

    inputStream
        .map((k, v) -> KeyValue.pair(v.id, Main.toJson(v)))
        .to("input-json-schema", Produced.with(Serdes.String(), jsonSchemaSerde));

    final var avroSchemaSerde = new GenericAvroSerde();
    avroSchemaSerde.configure(schemaRegistryConfig, false);

    inputStream
        .map((k, v) -> KeyValue.pair(v.id, Main.toAvro(v)))
        .to("input-avro", Produced.with(Serdes.String(), avroSchemaSerde));

    final var streamsConfig = new Properties();
    streamsConfig.put(StreamsConfig.APPLICATION_ID_CONFIG, "poc-adapter");
    streamsConfig
        .put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, config.getString("kafka.bootstrap-servers"));

    final var topology = builder.build();
    final var streams = new KafkaStreams(topology, streamsConfig);
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    streams.start();
  }

  private static GenericRecord toAvro(poc.adapter.xml.Book v) {
    GenericRecord avroRecord = new GenericData.Record(schema);
    avroRecord.put("id", v.id);
    avroRecord.put("author", v.author);
    avroRecord.put("title", v.title);
    avroRecord.put("genre", v.genre);
    avroRecord.put("price", v.price);
    avroRecord.put("publishDate", v.publishDate);
    avroRecord.put("description", v.description);
    return avroRecord;
  }

  private static Catalog parseXml(String raw) {
    try (final var reader = new StringReader(raw)) {
      final var unmarshaller = context.createUnmarshaller();
      return (Catalog) unmarshaller.unmarshal(reader);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static poc.adapter.json.Book toJson(poc.adapter.xml.Book book) {
    final var book1 = new Book();
    book1.author = book.author;
    book1.id = book.id;
    book1.description = book.description;
    book1.genre = book.genre;
    book1.title = book.title;
    book1.price = book.price;
    book1.publishDate = book.publishDate;
    return book1;
  }
}
