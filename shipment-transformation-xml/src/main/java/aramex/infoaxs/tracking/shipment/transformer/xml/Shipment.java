package aramex.infoaxs.tracking.shipment.transformer.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "HAWBUpdate")
public class Shipment {

  @JacksonXmlProperty(localName = "HAWBID")
  long hawbId;
  @JacksonXmlProperty(localName = "HAWBNumber")
  String hawbNumber;
  @JacksonXmlProperty(localName = "HAWBOriginEntity")
  String hawbOriginEntity;
  @JacksonXmlProperty(localName = "ForeignHAWBNumber")
  String foreignHawbNumber;
  @JacksonXmlProperty(localName = "Pieces")
  int pieces;
  @JacksonXmlProperty(localName = "UpdateEntity")
  String updateEntity;
  @JacksonXmlProperty(localName = "PINumber")
  String piNumber;
  @JacksonXmlProperty(localName = "ProblemCode")
  String problemCode;
  @JacksonXmlProperty(localName = "Comment1")
  String comment1;
  @JacksonXmlProperty(localName = "Comment2")
  String comment2;
  @JacksonXmlProperty(localName = "ActionDate")
  String actionDate;
  @JacksonXmlProperty(localName = "EntryDate")
  String entryDate;
  @JacksonXmlProperty(localName = "UserID")
  String userId;
  @JacksonXmlProperty(localName = "BranchID")
  long branchId;
  @JacksonXmlProperty(localName = "GeoLongitude")
  double geoLongitude;
  @JacksonXmlProperty(localName = "GeoLatitude")
  double geoLatitude;
  @JacksonXmlProperty(localName = "Source")
  String source;
  @JacksonXmlProperty(localName = "HAWBDetails")
  HawbDetails hawbDetails;
  @JacksonXmlProperty(localName = "MAWBDetails")
  MawbDetails mawbDetails;

  static class HawbDetails {

    @JacksonXmlProperty(localName = "HAWBNumber")
    String hawbNumber;
    @JacksonXmlProperty(localName = "ForeignHAWBNumber")
    String foreignHawbNumber;
    @JacksonXmlProperty(localName = "HAWBOriginEntity")
    String hawbOriginEntity;
    @JacksonXmlProperty(localName = "HAWBDestinationEntity")
    String hawbDestinationEntity;
    @JacksonXmlProperty(localName = "ProductType")
    String productType;
    @JacksonXmlProperty(localName = "Services")
    String services;
    @JacksonXmlProperty(localName = "Skeleton")
    boolean skeleton;
    @JacksonXmlProperty(localName = "PickupDate")
    String pickupDate;
    @JacksonXmlProperty(localName = "ReceivedAt")
    String receivedAt;
    @JacksonXmlProperty(localName = "Pieces")
    int pieces;
    @JacksonXmlProperty(localName = "HAWBWeight")
    double hawbWeight;
    @JacksonXmlProperty(localName = "HAWBWeightUnit")
    String hawbWeightUnit;
    @JacksonXmlProperty(localName = "ChargeableWeight")
    double chargeableWeight;
    @JacksonXmlProperty(localName = "PaymentType")
    String paymentType;
    @JacksonXmlProperty(localName = "CollectAmount")
    double collectAmount;
    @JacksonXmlProperty(localName = "CollectCurrencyCode")
    String collectCurrencyCode;
    @JacksonXmlProperty(localName = "CustomsAmount")
    double customsAmount;
    @JacksonXmlProperty(localName = "CustomsCurrencyCode")
    String customsCurrencyCode;
    @JacksonXmlProperty(localName = "CommodityCountryCode")
    String commodityCountryCode;
    @JacksonXmlProperty(localName = "CommodityDescription")
    String commodityDescription;
    @JacksonXmlProperty(localName = "BillingAccountNumber")
    String billingAccountNumber;

    //Shipper is passed as an object to JSON
    @JacksonXmlProperty(localName = "ShipperNumber")
    String shipperNumber;
    @JacksonXmlProperty(localName = "ShipperReference")
    String shipperReference;
    @JacksonXmlProperty(localName = "ShipperName")
    String shipperName;
    @JacksonXmlProperty(localName = "SentBy")
    String sentBy;
    @JacksonXmlProperty(localName = "ShipperAddress")
    String shipperAddress;
    @JacksonXmlProperty(localName = "ShipperAddress2")
    String shipperAddress2;
    @JacksonXmlProperty(localName = "ShipperTelephone")
    String shipperTelephone;
    @JacksonXmlProperty(localName = "ShipperCity")
    String shipperCity;
    @JacksonXmlProperty(localName = "ShipperStateCode")
    String shipperStateCode;
    @JacksonXmlProperty(localName = "ShipperZipCode")
    String shipperZipCode;
    @JacksonXmlProperty(localName = "ShipperCountryCode")
    String shipperCountryCode;
    @JacksonXmlProperty(localName = "ShipperID")
    long shipperId;
    @JacksonXmlProperty(localName = "ShipperTeamID")
    long shipperTeamId;
    @JacksonXmlProperty(localName = "ShipperReference2")
    String shipperReference2;
    @JacksonXmlProperty(localName = "ShipperFax")
    String shipperFax;
    @JacksonXmlProperty(localName = "ShipperEmail")
    String shipperEmail;
    @JacksonXmlProperty(localName = "ShipperMobile")
    String shipperMobile;

    // Consignee is Received at the JSON side
    @JacksonXmlProperty(localName = "ConsigneeNumber")
    String consigneeNumber;
    @JacksonXmlProperty(localName = "ConsigneeReference")
    String consigneeReference;
    @JacksonXmlProperty(localName = "ConsigneeName")
    String consigneeName;
    @JacksonXmlProperty(localName = "AttentionOf")
    String consigneeAttentionOf;
    @JacksonXmlProperty(localName = "ConsigneeAddress")
    String consigneeAddress;
    @JacksonXmlProperty(localName = "ConsigneeAddress2")
    String consigneeAddress2;
    @JacksonXmlProperty(localName = "ConsigneeTelephone")
    String consigneeTelephone;
    @JacksonXmlProperty(localName = "ConsigneeTelephone2")
    String consigneeTelephone2;
    @JacksonXmlProperty(localName = "ConsigneeCity")
    String consigneeCity;
    @JacksonXmlProperty(localName = "ConsigneeStateCode")
    String consigneeStateCode;
    @JacksonXmlProperty(localName = "ConsigneeZipCode")
    String consigneeZipCode;
    @JacksonXmlProperty(localName = "ConsigneeCountryCode")
    String consigneeCountryCode;
    @JacksonXmlProperty(localName = "ConsigneeID")
    long consigneeId;
    @JacksonXmlProperty(localName = "ConsigneeTeamID")
    long consigneeTeamId;
    @JacksonXmlProperty(localName = "ConsigneeReference2")
    String consigneeReference2;
    @JacksonXmlProperty(localName = "ConsigneeFax")
    String consigneeFax;
    @JacksonXmlProperty(localName = "ConsigneeEmail")
    String consigneeEmail;
    @JacksonXmlProperty(localName = "ConsigneeMobile")
    String consigneeMobile;

    // Third party is moved as an object in JSON
    @JacksonXmlProperty(localName = "ThirdPartyNumber")
    String thirdPartynumber;
    @JacksonXmlProperty(localName = "ThirdPartyReference")
    String thirdPartyReference;
    @JacksonXmlProperty(localName = "ThirdPartyName")
    String thirdPartyName;
    @JacksonXmlProperty(localName = "ThirdPartyContact")
    String thirdPartyContact;
    @JacksonXmlProperty(localName = "ThirdPartyAddress")
    String thirdPartyAddress;
    @JacksonXmlProperty(localName = "ThirdPartyAddress2")
    String thirdPartyAddress2;
    @JacksonXmlProperty(localName = "ThirdPartyTelephone")
    String thirdPartyTelephone;
    @JacksonXmlProperty(localName = "ThirdPartyCity")
    String thirdPartyCity;
    @JacksonXmlProperty(localName = "ThirdPartyStateCode")
    String thirdPartyStateCode;
    @JacksonXmlProperty(localName = "ThirdPartyZipCode")
    String thirdPartyZipCode;
    @JacksonXmlProperty(localName = "ThirdPartyCountryCode")
    String thirdPartyCountryCode;
    @JacksonXmlProperty(localName = "ThirdPartyID")
    long thirdPartyId;
    @JacksonXmlProperty(localName = "ThirdPartyTeamID")
    long thirdPartyTeamId;
    @JacksonXmlProperty(localName = "ThirdPartyEntity")
    String thirdPartyEntity;
    @JacksonXmlProperty(localName = "ThirdPartyReference2")
    String thirdPartyReference2;


    @JacksonXmlProperty(localName = "SourceID")
    long sourceId;
    @JacksonXmlProperty(localName = "HAWBRemarks")
    String hawbRemarks;
    @JacksonXmlProperty(localName = "CashValue")
    double cashValue;
    @JacksonXmlProperty(localName = "CashCurrencyCode")
    String cashCurrencyCode;
    @JacksonXmlProperty(localName = "InsuranceValue")
    double insuranceValue;
    @JacksonXmlProperty(localName = "InsuranceCurrencyCode")
    String insuranceCurrencyCode;
    @JacksonXmlProperty(localName = "CODValue")
    double codValue;
    @JacksonXmlProperty(localName = "CODCurrencyCode")
    String codCurrencyCode;
    @JacksonXmlProperty(localName = "PaymentOption")
    String paymentOption;
    @JacksonXmlProperty(localName = "SRNNumber")
    String srnNumber;
    @JacksonXmlProperty(localName = "HAWBProductGroup")
    String hawbProductGroup;

    //Moved to Shipper in json
    @JacksonXmlProperty(localName = "OriginLocationCode")
    String originLocationCode;
    //Moved to Received in Json
    @JacksonXmlProperty(localName = "DestinationLocationCode")
    String destinationLocationCode;


    @JacksonXmlProperty(localName = "HAWBRef1")
    String hawbRef1;
    @JacksonXmlProperty(localName = "HAWBRef2")
    String hawbRef2;
    @JacksonXmlProperty(localName = "HAWBRef3")
    String hawbRef3;
    @JacksonXmlProperty(localName = "HAWBAlertedBy")
    String hawbAlertedBy;
    @JacksonXmlProperty(localName = "HAWBAlertedDate")
    String hawbAlertedDate;
    @JacksonXmlProperty(localName = "DueDate")
    String dueDate;
    @JacksonXmlProperty(localName = "CollectionReference")
    String collectionReference;
    @JacksonXmlProperty(localName = "Cube")
    double cube;
    @JacksonXmlProperty(localName = "CubeUnit")
    String cubeUnit;
    @JacksonXmlProperty(localName = "AccountingInformation")
    String accountingInformation;
    @JacksonXmlProperty(localName = "PrepaidRangeID")
    long prepaidRangeId;

    @JacksonXmlProperty(localName = "HAWBDimensions")
    String hawbDimensions; //TODO Containing XML as String (!)

    @JacksonXmlProperty(localName = "AdditionalProperties")
    AdditionalProperties additionalProperties;
  }

  static class MawbDetails {

    @JacksonXmlProperty(localName = "Carrier")
    String carrier;
    @JacksonXmlProperty(localName = "OriginPort")
    String originPoint;
    @JacksonXmlProperty(localName = "MAWBNumber")
    String mawbNumber;
    @JacksonXmlProperty(localName = "DestinationPort")
    String destinationPort;
    @JacksonXmlProperty(localName = "OriginEntity")
    int originEntity;
    @JacksonXmlProperty(localName = "DestinationEntity")
    String destinationEntity;
    @JacksonXmlProperty(localName = "FLT1Carrier")
    String flt1Carrier;
    @JacksonXmlProperty(localName = "FLT1Number")
    String flt1Number;
    @JacksonXmlProperty(localName = "FLT1ETD")
    String flt1Etd;
    @JacksonXmlProperty(localName = "FLT1ETA")
    String flt1Eta;
    @JacksonXmlProperty(localName = "VIA1")
    String via1;
    @JacksonXmlProperty(localName = "FLT2Carrier")
    String flt2Carrier;
    @JacksonXmlProperty(localName = "FLT2Number")
    String flt2Number;
    @JacksonXmlProperty(localName = "FLT2ETD")
    String flt2Etd;
    @JacksonXmlProperty(localName = "FLT2ETA")
    String flt2Eta;
    @JacksonXmlProperty(localName = "VIA2")
    String via2;
    @JacksonXmlProperty(localName = "FLT3Carrier")
    String flt3Carrier;
    @JacksonXmlProperty(localName = "FLT3Number")
    String flt3Number;
    @JacksonXmlProperty(localName = "FLT3ETD")
    String flt3Etd;
    @JacksonXmlProperty(localName = "FLT3ETA")
    String flt3Eta;
    @JacksonXmlProperty(localName = "NetETA")
    String netEta;
    @JacksonXmlProperty(localName = "MotherBags")
    int motherBags;
    @JacksonXmlProperty(localName = "BabyBags")
    int babyBags;
    @JacksonXmlProperty(localName = "MAWBWeight")
    double mawbWeight;
    @JacksonXmlProperty(localName = "MAWBWeightUnit")
    String mawbWeighUnit;
    @JacksonXmlProperty(localName = "Remarks")
    String remarks;
    @JacksonXmlProperty(localName = "OriginEntityCode")
    String originEntityCode;
    @JacksonXmlProperty(localName = "DestinationEntityCode")
    String destinationEntityCode;
    @JacksonXmlProperty(localName = "MAWBRecoveryNotRequired")
    boolean mawbRecoveryNotRequired;
    @JacksonXmlProperty(localName = "MAWBContainerNumber")
    String mawbContainerNumber;
    @JacksonXmlProperty(localName = "FinalizedDate")
    String finalizedDate;
    @JacksonXmlProperty(localName = "ContractFltGrpsID")
    long contractfltGrpsId;
    @JacksonXmlProperty(localName = "SRRID")
    long srrId;
    @JacksonXmlProperty(localName = "MAWBID")
    long mawbId;
  }

  static class AdditionalProperties {
    @JacksonXmlProperty(localName = "ShipmentProfile")
    ShipmentProfile shipmentProfile;

    static class ShipmentProfile {
      @JacksonXmlProperty(localName = "BrandName")
      String brandName;
      @JacksonXmlProperty(localName = "BusinessType")
      String businessType;
    }
  }
}

