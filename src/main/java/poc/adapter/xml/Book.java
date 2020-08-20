package poc.adapter.xml;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {

  @XmlAttribute
  public String id;
  @XmlElement
  public String author;
  @XmlElement
  public String title;
  @XmlElement
  public String genre;
  @XmlElement
  public Double price;
  @XmlElement(name = "publish_date")
  public String publishDate;
  @XmlElement
  public String description;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(id, book.id) &&
        Objects.equals(author, book.author) &&
        Objects.equals(title, book.title) &&
        Objects.equals(genre, book.genre) &&
        Objects.equals(price, book.price) &&
        Objects.equals(publishDate, book.publishDate) &&
        Objects.equals(description, book.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, author, title, genre, price, publishDate, description);
  }
}
