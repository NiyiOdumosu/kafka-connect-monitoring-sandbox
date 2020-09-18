package shipment.tracking.transformer.xml2JsonMappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import shipment.tracking.transformer.xml.Tracking;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, uses= TrackingMapper.HawbDetailsMapper.class)
public abstract class TrackingMapper {

    public static TrackingMapper INSTANCE = Mappers.getMapper( TrackingMapper.class );

    @Mapping(target = "source", source = "sourceId")
    @Mapping(target = "geo", source = "shipment")
    @Mapping(target = "hawbDetails", source = "shipment")
    public abstract shipment.tracking.transformer.json.Tracking trackingXmlToJson(Tracking shipment);

    shipment.tracking.transformer.json.Tracking.Geo shipmentToGeo(Tracking shipment) {
        shipment.tracking.transformer.json.Tracking.Geo geo = new shipment.tracking.transformer.json.Tracking.Geo();

        //TODO: maybe add some logic here
        geo.setType("Point");

        double[] coords = {shipment.getGeoLatitude(), shipment.getGeoLongitude()};
        geo.setCoordinates(coords);

        return geo;
    }

    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, uses = HawbDimensionsMapper.class)
    abstract static class HawbDetailsMapper {
        public static HawbDetailsMapper INSTANCE = Mappers.getMapper( HawbDetailsMapper.class );

        @Mapping(target = "hawbDimensions.dim", source = "hawbDetails.hawbDimensions")
        abstract shipment.tracking.transformer.json.Tracking.HawbDetails hawbDetailsXmlToJson(Tracking shipment);
    }

    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, uses = DimMapper.class)
    abstract static class HawbDimensionsMapper {

        @Mapping(target = "dim", source = "hawbDetails.hawbDimensions")
        abstract shipment.tracking.transformer.json.Tracking.HawbDimensions hawbDimensionsXmlToJson(Tracking shipment);

    }

    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    interface DimMapper {

        @Mapping(target = "wf", source = "hawbDetails.hawbDimensions.wf")
        shipment.tracking.transformer.json.Tracking.HawbDimensions.Dim dimXmlToJson(Tracking shipment);
    }
}
