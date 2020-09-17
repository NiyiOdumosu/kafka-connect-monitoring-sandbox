package shipment.tracking.transformer.json;

public class Tracking {

  long hawbId;
  String hawbNumber;
  String hawbOriginEntity;
  String foreignHawbNumber;
  int pieces;
  String updateEntity;
  String piNumber;
  String problemCode;
  String comment1;
  String comment2;
  String actionDate;
  String entryDate;
  String userId;
  long branchId;
  Geo geo;
  String source;
  HawbDetails hawbDetails;
  Mawb mawb;

  static class HawbDetails {

    String hawbNumber;
    String hawbOriginEntity;
    String productType;
    String services;
    boolean skeleton;
    long pickupDate;
    String receivedAt;
    int pieces;
    double hawbWeight;
    String hawbWeightUnit;
    double chargeableWeight;
    String paymentType;
    double collectAmount;
    String collectCurrencyCode;
    double customsAmount;
    String customsCurrencyCode;
    String commodityCountryCode;
    String commodityDescription;
    String billingAccountNumber;
    long sourceId;
    String hawbRemarks;
    double cashValue;
    String cashCurrencyCode;
    double insuranceValue;
    String insuranceCurrencyCode;
    double codValue;
    String codCurrencyCode;
    String paymentOption;
    String srnNumber;
    String hawbProductGroup;
    String hawbRef1;
    String hawbRef2;
    String hawbRef3;
    String hawbAlertedBy;
    long hawbAlertedDate;
    long dueDate;
    String collectionReference;
    double cube;
    String cubeUnit;
    String accountingInformation;
    long prepaidRangeId;
    HawbDimensions hawbDimensions;
    AdditionalProperties additionalProperties;
    Shipper shipper;
    Receiver receiver;
    ThirdParty thirdParty;
  }

  static class Mawb {

    String carrier;
    String originPoint;
    String mawbNumber;
    String destinationPort;
    int originEntity;
    String destinationEntity;
    String flt1Carrier;
    String flt1Number;
    long flt1Etd;
    long flt1Eta;
    String via1;
    String flt2Carrier;
    String flt2Number;
    long flt2Etd;
    long flt2Eta;
    String via2;
    String flt3Carrier;
    String flt3Number;
    long flt3Etd;
    long flt3Eta;
    String via3;
    long netEta;
    int motherBags;
    int babyBags;
    double mawbWeight;
    String mawbWeighUnit;
    String remarks;
    String originEntityCode;
    String destinationEntityCode;
    boolean mawbRecoveryNotRequired;
    String mawbContainerNumber;
    long finalizedDate;
    long contractfltGrpsId;
    long srrId;
    long mawbId;
  }

  static class Geo {

    String type;
    double[] coordinates;
  }

  static class HawbDimensions {

    Dim dim;

    static class Dim {

      int wf;
      String wu;
      double[] p;
      double[] l;
      double[] w;
      double[] h;
      double[] gw;
      double[] vw;
      double[] cw;
    }
  }


  static class Shipper {

    String hawbOriginEntity;
    String number;
    String reference;
    String reference2;
    String name;
    String sentBy;
    String address;
    String address2;
    String telephone;
    String city;
    String stateCode;
    String zipCode;
    String countryCode;
    long id;
    long teamId;
    String fax;
    String email;
    String mobile;
    String originLocationCode;
  }

  static class ThirdParty {

    String number;
    String reference;
    String reference2;
    String name;
    String contact;
    String address;
    String address2;
    String telephone;
    String city;
    String stateCode;
    String zipCode;
    String countryCode;
    long id;
    long teamId;
    String entity;
  }

  static class AdditionalProperties {

    ShipmentProfile shipmentProfile;

    static class ShipmentProfile {

      String brandName;
      String businessType;
    }
  }


  static class Receiver {

    long id;
    long teamId;
    String hawbDestinationEntity;
    String number;
    String reference;
    String reference2;
    String name;
    String attentionOf;
    String address;
    String address2;
    String telephone;
    String telephone2;
    String city;
    String zipCode;
    String countryCode;
    String fax;
    String email;
    String destinationLocationCode;
    String mobile;
  }
}

