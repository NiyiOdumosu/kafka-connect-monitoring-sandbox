package shipment.tracking.transformer.xml2JsonMappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import shipment.tracking.transformer.xml.Tracking;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
        uses=TrackingMapper.HawbDetailsMapper.class)
public abstract class TrackingMapper {

    public static TrackingMapper INSTANCE = Mappers.getMapper( TrackingMapper.class );

    @Mapping(target = "source", source = "sourceId")
    @Mapping(target = "geo", source = "shipment")
    @Mapping(target = "hawbDetails", source = "hawbDetails")
    @Mapping(target = "mawb", source = "mawbDetails")
    public abstract shipment.tracking.transformer.json.Tracking trackingXmlToJson(Tracking shipment);

    shipment.tracking.transformer.json.Tracking.Geo shipmentToGeo(Tracking shipment) {
        shipment.tracking.transformer.json.Tracking.Geo geo = new shipment.tracking.transformer.json.Tracking.Geo();

        geo.setType("Point");

        double[] coords = {shipment.getGeoLatitude(), shipment.getGeoLongitude()};
        geo.setCoordinates(coords);

        return geo;
    }

    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, uses={TrackingMapper.ShipperMapper.class,
            TrackingMapper.ReceiverMapper.class, TrackingMapper.ThirdPartyMapper.class})
    interface HawbDetailsMapper {

        @Mapping(target = "hawbDimensions.dim", source = "hawbDimensions")
        @Mapping(target = "shipper", source = "hawbDetails")
        @Mapping(target = "receiver", source = "hawbDetails")
        @Mapping(target = "thirdParty", source = "hawbDetails")
        shipment.tracking.transformer.json.Tracking.HawbDetails hawbDetailsXmlToJson(Tracking.HawbDetails hawbDetails);
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
        shipment.tracking.transformer.json.Tracking.Shipper hawbDetailsXmlToShipperJson(Tracking.HawbDetails shipment);
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
        shipment.tracking.transformer.json.Tracking.Receiver hawbDetailsXmlToReceiverJson(Tracking.HawbDetails shipment);
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
        @Mapping(target = "entity", source = "thirdPartyEntity")
        @Mapping(target = "reference2", source = "thirdPartyReference2")
        shipment.tracking.transformer.json.Tracking.ThirdParty hawbDetailsXmlToThirdPartyJson(Tracking.HawbDetails shipment);
    }


}
