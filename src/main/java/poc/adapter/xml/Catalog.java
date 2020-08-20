package poc.adapter.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "catalog")
public class Catalog {

  @XmlElement(name = "book")
  public
  List<Book> books;

}
