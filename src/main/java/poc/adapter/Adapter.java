package poc.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import poc.adapter.json.Book;
import poc.adapter.xml.Catalog;

public class Adapter {
  static JAXBContext context;

  static {
    try {
      context = JAXBContext.newInstance(Catalog.class);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

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

  static GenericRecord toAvro(poc.adapter.xml.Book v) {
    final var avroRecord = new GenericData.Record(schema);
    avroRecord.put("id", v.id);
    avroRecord.put("author", v.author);
    avroRecord.put("title", v.title);
    avroRecord.put("genre", v.genre);
    avroRecord.put("price", v.price);
    avroRecord.put("publishDate", v.publishDate);
    avroRecord.put("description", v.description);
    return avroRecord;
  }

  static Catalog parseXml(String raw) {
    try (final var reader = new StringReader(raw)) {
      final var um = context.createUnmarshaller();
      return (Catalog) um.unmarshal(reader);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return null;
  }

  static poc.adapter.json.Book toJson(poc.adapter.xml.Book book) {
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

  static String toJsonString(Book v) {
    try {
      return mapper.writeValueAsString(v);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }
}
