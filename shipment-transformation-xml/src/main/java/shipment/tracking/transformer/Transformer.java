package shipment.tracking.transformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shipment.tracking.transformer.xml.HawbDimensions;
import shipment.tracking.transformer.xml.Tracking;
import shipment.tracking.transformer.xml2JsonMappers.TrackingMapper;

public class Transformer {

  static Logger logger = LoggerFactory.getLogger(Transformer.class);

  static XmlMapper xmlMapper = new XmlMapper();
  static ObjectMapper objectMapper = new ObjectMapper();

  static shipment.tracking.transformer.xml.Tracking parseXml(String raw) {
    try {
      logger.debug("INPUT: " + raw);

      return xmlMapper.readValue(raw, Tracking.class);
    } catch (JsonProcessingException e) {
      //TODO what to do when data is not 'parsable'?
      logger.warn("Error parsing XML: ", e);
      return null;
    }
  }

  static String convertToJson(Tracking shipment) {

    try {
      //Handle embedded XML
      if (shipment != null && shipment.getHawbDetails() != null) {
        String hawbDimensionsXmlString = shipment.getHawbDetails().getHawbDimensionsXmlString();

        HawbDimensions hawbDimensions = xmlMapper.readValue(hawbDimensionsXmlString, HawbDimensions.class);
        shipment.getHawbDetails().setHawbDimensions(hawbDimensions);
      }

      shipment.tracking.transformer.json.Tracking trackingJsonFormat = TrackingMapper.INSTANCE.trackingXmlToJson(shipment);

      return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(trackingJsonFormat);

    } catch (JsonProcessingException e) {
      logger.warn("Error parsing embedded XML: ", e);
      return null;
    }
  }

  public static void main(String[] args) {
    try {
      var path = "src/test/resources/tracking-activity.xml";
      var xml = Files.readString(Paths.get(path));
      var shipment = parseXml(xml);

      String json = convertToJson(shipment);

      System.out.println("JSON OUT:" +json);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
