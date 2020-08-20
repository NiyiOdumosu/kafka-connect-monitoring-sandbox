package poc.adapter.xml;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.junit.jupiter.api.Test;

class CatalogTest {

  @Test
  void shouldMarshalUnmarshalXml() throws Exception {
    //Given
    var catalog = new Catalog();
    var book1 = new Book();
    book1.id = "bk01";
    book1.author = "Galos, Mike";
    book1.title = "Visual Studio 7: A comprehensive guide";
    book1.genre = "Computer";
    book1.price = 49.95;
    book1.publishDate = "2001-04-16";
    book1.description = "....";
    var book2 = new Book();
    book2.id = "bk02";
    book2.author = "Galos, Mike";
    book2.title = "Visual Studio 7: A comprehensive guide";
    book2.genre = "Computer";
    book2.price = 49.95;
    book2.publishDate = "2001-04-16";
    book2.description = "....";

    catalog.books = List.of(book1, book2);
    //When
    final var context = JAXBContext.newInstance(Catalog.class);

    final var marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    final var writer = new StringWriter();
    marshaller.marshal(catalog, writer);

    final var reader = new StringReader(writer.toString());

    final var unmarshaller = context.createUnmarshaller();
    final var output = (Catalog) unmarshaller.unmarshal(reader);
    //Then
    assertThat(output.books)
        .containsExactly(book1, book2)
        .hasSize(2);
  }
}