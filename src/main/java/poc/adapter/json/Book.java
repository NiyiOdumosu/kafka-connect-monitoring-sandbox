package poc.adapter.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Book {

  @JsonProperty
  public String id;
  @JsonProperty
  public String author;
  @JsonProperty
  public String title;
  @JsonProperty
  public String genre;
  @JsonProperty
  public Double price;
  @JsonProperty("publish_date")
  public String publishDate;
  @JsonProperty
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
