package shipment.activity.transformer.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ShipmentActivityXmlConversionResult {

    @Getter
    ShipmentActivity shipmentActivity;
    @Getter Map<String, String> errorInfo;

    static Logger logger = LoggerFactory.getLogger(ShipmentActivityXmlConversionResult.class);

    public ShipmentActivityXmlConversionResult(ShipmentActivity shipmentActivityParam, Map<String, String> errorInfoParam) {
        this.shipmentActivity = shipmentActivityParam;
        this.errorInfo = errorInfoParam;
    }

    public static String mapToJsonString(Map<String, String> errorInfoParam) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorInfoParam);
        } catch (JsonProcessingException e) {
            logger.warn("Error converting error info to JSON: ", e);
            return "{}";
        }
    }

}

