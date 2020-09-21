package shipment.tracking.transformer.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "HAWBUpdate")
public class Tracking {

  @Getter @JacksonXmlProperty(localName = "HAWBID")
  long hawbId;
  @Getter @JacksonXmlProperty(localName = "HAWBNumber")
  String hawbNumber;
  @Getter @JacksonXmlProperty(localName = "HAWBOriginEntity")
  String hawbOriginEntity;
  @Getter @JacksonXmlProperty(localName = "ForeignHAWBNumber")
  String foreignHawbNumber;
  @Getter @JacksonXmlProperty(localName = "Pieces")
  int pieces;
  @Getter @JacksonXmlProperty(localName = "UpdateEntity")
  String updateEntity;
  @Getter @JacksonXmlProperty(localName = "PINumber")
  String piNumber;
  @Getter @JacksonXmlProperty(localName = "ProblemCode")
  String problemCode;
  @Getter @JacksonXmlProperty(localName = "Comment1")
  String comment1;
  @Getter @JacksonXmlProperty(localName = "Comment2")
  String comment2;
  @Getter @JacksonXmlProperty(localName = "ActionDate")
  String actionDate;
  @Getter @JacksonXmlProperty(localName = "EntryDate")
  String entryDate;
  @Getter @JacksonXmlProperty(localName = "UserID")
  String userId;
  @Getter @JacksonXmlProperty(localName = "BranchID")
  long branchId;
  @Getter @JacksonXmlProperty(localName = "GeoLongitude")
  double geoLongitude;
  @Getter @JacksonXmlProperty(localName = "GeoLatitude")
  double geoLatitude;
  @Getter @JacksonXmlProperty(localName = "Source")
  String sourceId;
  @Getter @JacksonXmlProperty(localName = "HAWBDetails")
  HawbDetails hawbDetails;
  @Getter @JacksonXmlProperty(localName = "MAWBDetails")
  MawbDetails mawbDetails;

  public static class HawbDetails {

    @Getter @JacksonXmlProperty(localName = "HAWBNumber")
    String hawbNumber;
    @Getter @JacksonXmlProperty(localName = "ForeignHAWBNumber")
    String foreignHawbNumber;
    @Getter @JacksonXmlProperty(localName = "HAWBOriginEntity")
    String hawbOriginEntity;
    @Getter @JacksonXmlProperty(localName = "HAWBDestinationEntity")
    String hawbDestinationEntity;
    @Getter @JacksonXmlProperty(localName = "ProductType")
    String productType;
    @Getter @JacksonXmlProperty(localName = "Services")
    String services;
    @Getter @JacksonXmlProperty(localName = "Skeleton")
    boolean skeleton;
    @Getter @JacksonXmlProperty(localName = "PickupDate")
    String pickupDate;
    @Getter @JacksonXmlProperty(localName = "ReceivedAt")
    String receivedAt;
    @Getter @JacksonXmlProperty(localName = "Pieces")
    int pieces;
    @Getter @JacksonXmlProperty(localName = "HAWBWeight")
    double hawbWeight;
    @Getter @JacksonXmlProperty(localName = "HAWBWeightUnit")
    String hawbWeightUnit;
    @Getter @JacksonXmlProperty(localName = "ChargeableWeight")
    double chargeableWeight;
    @Getter @JacksonXmlProperty(localName = "PaymentType")
    String paymentType;
    @Getter @JacksonXmlProperty(localName = "CollectAmount")
    double collectAmount;
    @Getter @JacksonXmlProperty(localName = "CollectCurrencyCode")
    String collectCurrencyCode;
    @Getter @JacksonXmlProperty(localName = "CustomsAmount")
    double customsAmount;
    @Getter @JacksonXmlProperty(localName = "CustomsCurrencyCode")
    String customsCurrencyCode;
    @Getter @JacksonXmlProperty(localName = "CommodityCountryCode")
    String commodityCountryCode;
    @Getter @JacksonXmlProperty(localName = "CommodityDescription")
    String commodityDescription;
    @Getter @JacksonXmlProperty(localName = "BillingAccountNumber")
    String billingAccountNumber;

    //Shipper is passed as an object to JSON
    @Getter @JacksonXmlProperty(localName = "ShipperNumber")
    String shipperNumber;
    @Getter @JacksonXmlProperty(localName = "ShipperReference")
    String shipperReference;
    @Getter @JacksonXmlProperty(localName = "ShipperName")
    String shipperName;
    @Getter @JacksonXmlProperty(localName = "SentBy")
    String sentBy;
    @Getter @JacksonXmlProperty(localName = "ShipperAddress")
    String shipperAddress;
    @Getter @JacksonXmlProperty(localName = "ShipperAddress2")
    String shipperAddress2;
    @Getter @JacksonXmlProperty(localName = "ShipperTelephone")
    String shipperTelephone;
    @Getter @JacksonXmlProperty(localName = "ShipperCity")
    String shipperCity;
    @Getter @JacksonXmlProperty(localName = "ShipperStateCode")
    String shipperStateCode;
    @Getter @JacksonXmlProperty(localName = "ShipperZipCode")
    String shipperZipCode;
    @Getter @JacksonXmlProperty(localName = "ShipperCountryCode")
    String shipperCountryCode;
    @Getter @JacksonXmlProperty(localName = "ShipperID")
    long shipperId;
    @Getter @JacksonXmlProperty(localName = "ShipperTeamID")
    long shipperTeamId;
    @Getter @JacksonXmlProperty(localName = "ShipperReference2")
    String shipperReference2;
    @Getter @JacksonXmlProperty(localName = "ShipperFax")
    String shipperFax;
    @Getter @JacksonXmlProperty(localName = "ShipperEmail")
    String shipperEmail;
    @Getter @JacksonXmlProperty(localName = "ShipperMobile")
    String shipperMobile;

    // Consignee is Received at the JSON side
    @Getter @JacksonXmlProperty(localName = "ConsigneeNumber")
    String consigneeNumber;
    @Getter @JacksonXmlProperty(localName = "ConsigneeReference")
    String consigneeReference;
    @Getter @JacksonXmlProperty(localName = "ConsigneeName")
    String consigneeName;
    @Getter @JacksonXmlProperty(localName = "AttentionOf")
    String attentionOf;
    @Getter @JacksonXmlProperty(localName = "ConsigneeAddress")
    String consigneeAddress;
    @Getter @JacksonXmlProperty(localName = "ConsigneeAddress2")
    String consigneeAddress2;
    @Getter @JacksonXmlProperty(localName = "ConsigneeTelephone")
    String consigneeTelephone;
    @Getter @JacksonXmlProperty(localName = "ConsigneeTelephone2")
    String consigneeTelephone2;
    @Getter @JacksonXmlProperty(localName = "ConsigneeCity")
    String consigneeCity;
    @Getter @JacksonXmlProperty(localName = "ConsigneeStateCode")
    String consigneeStateCode;
    @Getter @JacksonXmlProperty(localName = "ConsigneeZipCode")
    String consigneeZipCode;
    @Getter @JacksonXmlProperty(localName = "ConsigneeCountryCode")
    String consigneeCountryCode;
    @Getter @JacksonXmlProperty(localName = "ConsigneeID")
    long consigneeId;
    @Getter @JacksonXmlProperty(localName = "ConsigneeTeamID")
    long consigneeTeamId;
    @Getter @JacksonXmlProperty(localName = "ConsigneeReference2")
    String consigneeReference2;
    @Getter @JacksonXmlProperty(localName = "ConsigneeFax")
    String consigneeFax;
    @Getter @JacksonXmlProperty(localName = "ConsigneeEmail")
    String consigneeEmail;
    @Getter @JacksonXmlProperty(localName = "ConsigneeMobile")
    String consigneeMobile;

    // Third party is moved as an object in JSON
    @Getter @JacksonXmlProperty(localName = "ThirdPartyNumber")
    String thirdPartyNumber;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyReference")
    String thirdPartyReference;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyName")
    String thirdPartyName;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyContact")
    String thirdPartyContact;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyAddress")
    String thirdPartyAddress;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyAddress2")
    String thirdPartyAddress2;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyTelephone")
    String thirdPartyTelephone;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyCity")
    String thirdPartyCity;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyStateCode")
    String thirdPartyStateCode;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyZipCode")
    String thirdPartyZipCode;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyCountryCode")
    String thirdPartyCountryCode;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyID")
    long thirdPartyId;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyTeamID")
    long thirdPartyTeamId;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyEntity")
    String thirdPartyEntity;
    @Getter @JacksonXmlProperty(localName = "ThirdPartyReference2")
    String thirdPartyReference2;


    @Getter @JacksonXmlProperty(localName = "SourceID")
    long sourceId;
    @Getter @JacksonXmlProperty(localName = "HAWBRemarks")
    String hawbRemarks;
    @Getter @JacksonXmlProperty(localName = "CashValue")
    double cashValue;
    @Getter @JacksonXmlProperty(localName = "CashCurrencyCode")
    String cashCurrencyCode;
    @Getter @JacksonXmlProperty(localName = "InsuranceValue")
    double insuranceValue;
    @Getter @JacksonXmlProperty(localName = "InsuranceCurrencyCode")
    String insuranceCurrencyCode;
    @Getter @JacksonXmlProperty(localName = "CODValue")
    double codValue;
    @Getter @JacksonXmlProperty(localName = "CODCurrencyCode")
    String codCurrencyCode;
    @Getter @JacksonXmlProperty(localName = "PaymentOption")
    String paymentOption;
    @Getter @JacksonXmlProperty(localName = "SRNNumber")
    String srnNumber;
    @Getter @JacksonXmlProperty(localName = "HAWBProductGroup")
    String hawbProductGroup;

    //Moved to Shipper in json
    @Getter @JacksonXmlProperty(localName = "OriginLocationCode")
    String originLocationCode;
    //Moved to Received in Json
    @Getter @JacksonXmlProperty(localName = "DestinationLocationCode")
    String destinationLocationCode;


    @Getter @JacksonXmlProperty(localName = "HAWBRef1")
    String hawbRef1;
    @Getter @JacksonXmlProperty(localName = "HAWBRef2")
    String hawbRef2;
    @Getter @JacksonXmlProperty(localName = "HAWBRef3")
    String hawbRef3;
    @Getter @JacksonXmlProperty(localName = "HAWBAlertedBy")
    String hawbAlertedBy;
    @Getter @JacksonXmlProperty(localName = "HAWBAlertedDate")
    String hawbAlertedDate;
    @Getter @JacksonXmlProperty(localName = "DueDate")
    String dueDate;
    @Getter @JacksonXmlProperty(localName = "CollectionReference")
    String collectionReference;
    @Getter @JacksonXmlProperty(localName = "Cube")
    double cube;
    @Getter @JacksonXmlProperty(localName = "CubeUnit")
    String cubeUnit;
    @Getter @JacksonXmlProperty(localName = "AccountingInformation")
    String accountingInformation;
    @Getter @JacksonXmlProperty(localName = "PrepaidRangeID")
    long prepaidRangeId;

    @Getter @JacksonXmlProperty(localName = "HAWBDimensions")
    String hawbDimensionsXmlString;

    @Getter @Setter HawbDimensions hawbDimensions;

    @Getter @JacksonXmlProperty(localName = "AdditionalProperties")
    AdditionalProperties additionalProperties;
    
  }

  public static class MawbDetails {

    @Getter @JacksonXmlProperty(localName = "Carrier")
    String carrier;
    @Getter @JacksonXmlProperty(localName = "OriginPort")
    String originPoint;
    @Getter @JacksonXmlProperty(localName = "MAWBNumber")
    String mawbNumber;
    @Getter @JacksonXmlProperty(localName = "DestinationPort")
    String destinationPort;
    @Getter @JacksonXmlProperty(localName = "OriginEntity")
    int originEntity;
    @Getter @JacksonXmlProperty(localName = "DestinationEntity")
    String destinationEntity;
    @Getter @JacksonXmlProperty(localName = "FLT1Carrier")
    String flt1Carrier;
    @Getter @JacksonXmlProperty(localName = "FLT1Number")
    String flt1Number;
    @Getter @JacksonXmlProperty(localName = "FLT1ETD")
    String flt1Etd;
    @Getter @JacksonXmlProperty(localName = "FLT1ETA")
    String flt1Eta;
    @Getter @JacksonXmlProperty(localName = "VIA1")
    String via1;
    @Getter @JacksonXmlProperty(localName = "FLT2Carrier")
    String flt2Carrier;
    @Getter @JacksonXmlProperty(localName = "FLT2Number")
    String flt2Number;
    @Getter @JacksonXmlProperty(localName = "FLT2ETD")
    String flt2Etd;
    @Getter @JacksonXmlProperty(localName = "FLT2ETA")
    String flt2Eta;
    @Getter @JacksonXmlProperty(localName = "VIA2")
    String via2;
    @Getter @JacksonXmlProperty(localName = "FLT3Carrier")
    String flt3Carrier;
    @Getter @JacksonXmlProperty(localName = "FLT3Number")
    String flt3Number;
    @Getter @JacksonXmlProperty(localName = "FLT3ETD")
    String flt3Etd;
    @Getter @JacksonXmlProperty(localName = "FLT3ETA")
    String flt3Eta;
    @Getter @JacksonXmlProperty(localName = "NetETA")
    String netEta;
    @Getter @JacksonXmlProperty(localName = "MotherBags")
    int motherBags;
    @Getter @JacksonXmlProperty(localName = "BabyBags")
    int babyBags;
    @Getter @JacksonXmlProperty(localName = "MAWBWeight")
    double mawbWeight;
    @Getter @JacksonXmlProperty(localName = "MAWBWeightUnit")
    String mawbWeighUnit;
    @Getter @JacksonXmlProperty(localName = "Remarks")
    String remarks;
    @Getter @JacksonXmlProperty(localName = "OriginEntityCode")
    String originEntityCode;
    @Getter @JacksonXmlProperty(localName = "DestinationEntityCode")
    String destinationEntityCode;
    @Getter @JacksonXmlProperty(localName = "MAWBRecoveryNotRequired")
    boolean mawbRecoveryNotRequired;
    @Getter @JacksonXmlProperty(localName = "MAWBContainerNumber")
    String mawbContainerNumber;
    @Getter @JacksonXmlProperty(localName = "FinalizedDate")
    String finalizedDate;
    @Getter @JacksonXmlProperty(localName = "ContractFltGrpsID")
    long contractfltGrpsId;
    @Getter @JacksonXmlProperty(localName = "SRRID")
    long srrId;
    @Getter @JacksonXmlProperty(localName = "MAWBID")
    long mawbId;
  }

  public static class AdditionalProperties {

    @Getter @JacksonXmlProperty(localName = "ShipmentProfile")
    ShipmentProfile shipmentProfile;


    public static class ShipmentProfile {

      @Getter @JacksonXmlProperty(localName = "BrandName")
      String brandName;
      @Getter @JacksonXmlProperty(localName = "BusinessType")
      String businessType;
    }
  }
}

