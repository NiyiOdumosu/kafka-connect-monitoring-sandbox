package shipment.tracking.transformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shipment.tracking.transformer.xml.HawbDimensions;
import shipment.tracking.transformer.xml.Tracking;
import shipment.tracking.transformer.xml2JsonMappers.TrackingMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class Transformer {

  static Logger logger = LoggerFactory.getLogger(Transformer.class);

  static XmlMapper xmlMapper = new XmlMapper();
  static ObjectMapper objectMapper = new ObjectMapper();

  static shipment.tracking.transformer.xml.Tracking parseXml(String rawXml) {
    try {
      logger.debug("XML: " + rawXml);

      xmlMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

      Tracking tracking = xmlMapper.readValue(rawXml, Tracking.class);

      JsonNode additionalProperties = extractAdditionalProperties(rawXml);

      Optional.ofNullable(tracking)
              .map(e -> e.getHawbDetails())
              .ifPresent(e -> e.setAdditionalProperties(additionalProperties));

      return tracking;
    } catch (JsonProcessingException e) {

      logger.warn("Error parsing XML: ", e);
      return null;
    }
  }

  private static JsonNode extractAdditionalProperties(String rawXML) {

    try {
      JsonNode jsonNode = xmlMapper.readTree(rawXML);

      JsonNode additionalProperties = Optional.ofNullable(jsonNode)
              .map(e -> e.get("HAWBDetails"))
              .map(e -> e.get("AdditionalProperties"))
              .orElse(null);

      logger.debug("Additional properties: " + additionalProperties);

      return additionalProperties;
    } catch (JsonProcessingException e) {

      logger.warn("Error extracting additional properties from XML: ", e);
      return null;
    }
  }

  static String convertToJson(Tracking shipment) {

    try {
      //Handle embedded XML
      if (shipment != null && shipment.getHawbDetails() != null) {
        String hawbDimensionsXmlString = shipment.getHawbDetails().getHawbDimensionsXmlString();

        if (hawbDimensionsXmlString != "") {
          logger.debug("Embedded XML string: " + hawbDimensionsXmlString);
          HawbDimensions hawbDimensions = xmlMapper.readValue(hawbDimensionsXmlString, HawbDimensions.class);
          shipment.getHawbDetails().setHawbDimensions(hawbDimensions);
        }
      }

      shipment.tracking.transformer.json.Tracking trackingJsonFormat = TrackingMapper.INSTANCE.trackingXmlToJson(shipment);

      logger.debug("JSON: " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(trackingJsonFormat));

      return objectMapper.writeValueAsString(trackingJsonFormat);

    } catch (JsonProcessingException e) {
      logger.warn("Error parsing embedded XML: ", e);
      return null;
    }
  }

  //For local development
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
