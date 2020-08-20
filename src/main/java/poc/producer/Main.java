package poc.producer;

import com.typesafe.config.ConfigFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import static java.lang.System.out;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;

public class Main {

  public static void main(String[] args) throws IOException {
    final var config = ConfigFactory.load();

    final var producerConfig = new Properties();
    producerConfig.put(BOOTSTRAP_SERVERS_CONFIG, config.getString("kafka.bootstrap-servers"));

    final var keySerializer = new StringSerializer();
    final var valueSerializer = new StringSerializer();
    final var producer = new KafkaProducer<>(producerConfig, keySerializer, valueSerializer);

    final var xml = Files.readString(Paths.get("input1.xml"));

    final var record = new ProducerRecord<>("input", "k1", xml);
    producer.send(record, (recordMetadata, e) -> {
      if (e == null) {
        out.println("Record sent: " + recordMetadata);
      } else {
        e.printStackTrace();
      }
    });

    producer.flush();
    producer.close();
  }
}
