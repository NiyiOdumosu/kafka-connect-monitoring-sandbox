package aramex.infoaxs.tracking.shipment.transformer;

import aramex.infoaxs.tracking.shipment.transformer.xml.Shipment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.avro.AvroMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.avro.Schema;

public class Transformer {
  static AvroMapper avroMapper = new AvroMapper();
  static XmlMapper xmlMapper = new XmlMapper();
  static ObjectMapper objectMapper = new ObjectMapper();

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
  static final ObjectMapper mapper = new ObjectMapper();

//  static GenericRecord toAvro(poc.adapter.xml.Book v) {
//    final var avroRecord = new GenericData.Record(schema);
//    avroRecord.put("id", v.id);
//    avroRecord.put("author", v.author);
//    avroRecord.put("title", v.title);
//    avroRecord.put("genre", v.genre);
//    avroRecord.put("price", v.price);
//    avroRecord.put("publishDate", v.publishDate);
//    avroRecord.put("description", v.description);
//    return avroRecord;
//  }

  static Shipment parseXml(String raw) {
    try {
      return xmlMapper.readValue(raw, Shipment.class);
    } catch (JsonProcessingException e) {
      //TODO what to do when data is not 'parseable'?
      e.printStackTrace();
      return null;
    }
  }

//  static poc.adapter.json.Book toJson(poc.adapter.xml.Book book) {
//    final var book1 = new Book();
//    book1.author = book.author;
//    book1.id = book.id;
//    book1.description = book.description;
//    book1.genre = book.genre;
//    book1.title = book.title;
//    book1.price = book.price;
//    book1.publishDate = book.publishDate;
//    return book1;
//  }

//  static String toJsonString(Book v) {
//    try {
//      return mapper.writeValueAsString(v);
//    } catch (JsonProcessingException e) {
//      e.printStackTrace();
//      return null;
//    }
//  }

  public static void main(String[] args) {
    try {
      String xml = Files.readString(Paths.get("./shipment-transformation-xml/src/test/resources/tracking-activity.xml"));
      Shipment shipment = parseXml(xml);
      System.out.println(shipment);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
