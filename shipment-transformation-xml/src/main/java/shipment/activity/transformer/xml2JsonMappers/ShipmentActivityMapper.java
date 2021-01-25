package shipment.activity.transformer.xml2JsonMappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import shipment.activity.transformer.json.ShipmentActivity;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
        uses= ShipmentActivityMapper.ShipmentDetailsMapper.class)
public abstract class ShipmentActivityMapper {

    public static ShipmentActivityMapper INSTANCE = Mappers.getMapper( ShipmentActivityMapper.class );

    @Mapping(target = "source", source = "sourceId")
    @Mapping(target = "geo", source = "shipment")
    @Mapping(target = "shipmentDetails", source = "shipmentDetails")
    @Mapping(target = "mawb", source = "mawbDetails")
    public abstract ShipmentActivity trackingXmlToJson(shipment.activity.transformer.xml.ShipmentActivity shipment);

    ShipmentActivity.Geo shipmentToGeo(shipment.activity.transformer.xml.ShipmentActivity shipment) {
        ShipmentActivity.Geo geo = new ShipmentActivity.Geo();

        geo.setType("Point");

        double[] coords = {shipment.getGeoLatitude(), shipment.getGeoLongitude()};
        geo.setCoordinates(coords);

        return geo;
    }

    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, uses={ShipperMapper.class,
            ReceiverMapper.class, ThirdPartyMapper.class})
    interface ShipmentDetailsMapper {

        @Mapping(target = "shipmentDimensions.dim", source = "shipmentDimensions")
        @Mapping(target = "shipper", source = "shipmentDetails")
        @Mapping(target = "receiver", source = "shipmentDetails")
        @Mapping(target = "thirdParty", source = "shipmentDetails")
        ShipmentActivity.ShipmentDetails shipmentDetailsXmlToJson(shipment.activity.transformer.xml.ShipmentActivity.ShipmentDetails shipmentDetails);
    }

    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    interface ShipperMapper {

        @Mapping(target = "number", source = "shipperNumber")
        @Mapping(target = "reference", source = "shipperReference")
        @Mapping(target = "name", source = "shipperName")
        @Mapping(target = "address", source = "shipperAddress")
        @Mapping(target = "address2", source = "shipperAddress2")
        @Mapping(target = "telephone", source = "shipperTelephone")
        @Mapping(target = "city", source = "shipperCity")
        @Mapping(target = "stateCode", source = "shipperStateCode")
        @Mapping(target = "zipCode", source = "shipperZipCode")
        @Mapping(target = "countryCode", source = "shipperCountryCode")
        @Mapping(target = "id", source = "shipperId")
        @Mapping(target = "teamId", source = "shipperTeamId")
        @Mapping(target = "reference2", source = "shipperReference2")
        @Mapping(target = "fax", source = "shipperFax")
        @Mapping(target = "email", source = "shipperEmail")
        @Mapping(target = "mobile", source = "shipperMobile")
        ShipmentActivity.Shipper shipmentDetailsXmlToShipperJson(shipment.activity.transformer.xml.ShipmentActivity.ShipmentDetails shipment);
    }

    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    interface ReceiverMapper {

        @Mapping(target = "number", source = "consigneeNumber")
        @Mapping(target = "reference", source = "consigneeReference")
        @Mapping(target = "name", source = "consigneeName")
        @Mapping(target = "address", source = "consigneeAddress")
        @Mapping(target = "address2", source = "consigneeAddress2")
        @Mapping(target = "telephone", source = "consigneeTelephone")
        @Mapping(target = "telephone2", source = "consigneeTelephone2")
        @Mapping(target = "city", source = "consigneeCity")
        @Mapping(target = "stateCode", source = "consigneeStateCode")
        @Mapping(target = "zipCode", source = "consigneeZipCode")
        @Mapping(target = "countryCode", source = "consigneeCountryCode")
        @Mapping(target = "id", source = "consigneeId")
        @Mapping(target = "teamId", source = "consigneeTeamId")
        @Mapping(target = "reference2", source = "consigneeReference2")
        @Mapping(target = "fax", source = "consigneeFax")
        @Mapping(target = "email", source = "consigneeEmail")
        @Mapping(target = "mobile", source = "consigneeMobile")
        ShipmentActivity.Receiver shipmentDetailsXmlToReceiverJson(shipment.activity.transformer.xml.ShipmentActivity.ShipmentDetails shipment);
    }

    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    interface ThirdPartyMapper {

        @Mapping(target = "number", source = "thirdPartyNumber")
        @Mapping(target = "reference", source = "thirdPartyReference")
        @Mapping(target = "name", source = "thirdPartyName")
        @Mapping(target = "contact", source = "thirdPartyContact")
        @Mapping(target = "address", source = "thirdPartyAddress")
        @Mapping(target = "address2", source = "thirdPartyAddress2")
        @Mapping(target = "telephone", source = "thirdPartyTelephone")
        @Mapping(target = "city", source = "thirdPartyCity")
        @Mapping(target = "stateCode", source = "thirdPartyStateCode")
        @Mapping(target = "zipCode", source = "thirdPartyZipCode")
        @Mapping(target = "countryCode", source = "thirdPartyCountryCode")
        @Mapping(target = "id", source = "thirdPartyId")
        @Mapping(target = "teamId", source = "thirdPartyTeamId")
        @Mapping(target = "company", source = "thirdPartyEntity")
        @Mapping(target = "reference2", source = "thirdPartyReference2")
        ShipmentActivity.ThirdParty shipmentDetailsXmlToThirdPartyJson(shipment.activity.transformer.xml.ShipmentActivity.ShipmentDetails shipment);
    }


}
