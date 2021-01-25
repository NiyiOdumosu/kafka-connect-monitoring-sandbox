package shipment.activity.transformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shipment.activity.transformer.json.ShipmentActivity;
import shipment.activity.transformer.xml.ShipmentDimensions;
import shipment.activity.transformer.xml.ShipmentActivityXmlConversionResult;
import shipment.activity.transformer.xml2JsonMappers.ShipmentActivityMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Transformer {

  static Logger logger = LoggerFactory.getLogger(Transformer.class);

  static XmlMapper xmlMapper = new XmlMapper();
  static ObjectMapper objectMapper = new ObjectMapper();

  static ShipmentActivityXmlConversionResult parseXml(String rawXml) {
    try {
      logger.debug("XML: " + rawXml);

      xmlMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

      shipment.activity.transformer.xml.ShipmentActivity shipmentActivity = xmlMapper.readValue(rawXml, shipment.activity.transformer.xml.ShipmentActivity.class);

      //Handle embedded XML
      if (shipmentActivity.getShipmentDetails() != null) {
        String shipmentDimensionsXmlString = shipmentActivity.getShipmentDetails().getShipmentDimensionsXmlString();

        if (shipmentDimensionsXmlString != null && !shipmentDimensionsXmlString.isBlank()) {
          logger.debug("Embedded XML string: " + shipmentDimensionsXmlString);
          ShipmentDimensions shipmentDimensions = xmlMapper.readValue(shipmentDimensionsXmlString, ShipmentDimensions.class);
          shipmentActivity.getShipmentDetails().setShipmentDimensions(shipmentDimensions);
        }
      }

      JsonNode additionalProperties = extractAdditionalProperties(rawXml);

      Optional.ofNullable(shipmentActivity)
              .map(e -> e.getShipmentDetails())
              .ifPresent(e -> e.setAdditionalProperties(additionalProperties));

      return new ShipmentActivityXmlConversionResult(shipmentActivity, null);
    } catch (JsonProcessingException e) {

      logger.warn("Error parsing XML: ", e);

      Map<String,String> errorInfo = new HashMap<>();
      errorInfo.put("errorMessage", e.getMessage());
      errorInfo.put("rawXml", rawXml);

      return new ShipmentActivityXmlConversionResult(null, errorInfo);
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

  static String convertToJson(ShipmentActivityXmlConversionResult xmlConversionResult) {

    try {
      shipment.activity.transformer.xml.ShipmentActivity shipment = xmlConversionResult.getShipmentActivity();

      ShipmentActivity shipmentActivityJsonFormat = ShipmentActivityMapper.INSTANCE.trackingXmlToJson(shipment);

      logger.debug("JSON: " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(shipmentActivityJsonFormat));

      return objectMapper.writeValueAsString(shipmentActivityJsonFormat);

    } catch (JsonProcessingException e) { //Shouldn't really happen
      logger.warn("Error converting object to JSON: ", e);
      return null;
    }
  }

  //For local development
  public static void main(String[] args) {
    try {
      var path = "src/test/resources/tracking-activity.xml";
      var xml = Files.readString(Paths.get(path));
      var xmlConversionResult = parseXml(xml);

      String json = convertToJson(xmlConversionResult);

      System.out.println("JSON OUT:" +json);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
