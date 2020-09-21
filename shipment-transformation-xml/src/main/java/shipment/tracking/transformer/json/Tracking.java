package shipment.tracking.transformer.json;

import lombok.Getter;
import lombok.Setter;

public class Tracking {

  @Getter @Setter long hawbId;
  @Getter @Setter String hawbNumber;
  @Getter @Setter String hawbOriginEntity;
  @Getter @Setter String foreignHawbNumber;
  @Getter @Setter int pieces;
  @Getter @Setter String updateEntity;
  @Getter @Setter String piNumber;
  @Getter @Setter String problemCode;
  @Getter @Setter String comment1;
  @Getter @Setter String comment2;
  @Getter @Setter String actionDate;
  @Getter @Setter String entryDate;
  @Getter @Setter String userId;
  @Getter @Setter long branchId;

  @Getter @Setter Geo geo;
  @Getter @Setter String source;
  @Getter @Setter HawbDetails hawbDetails;
  Mawb mawb;

  public static class  HawbDetails {

    @Getter @Setter String hawbNumber;
    @Getter @Setter String foreignHawbNumber;
    @Getter @Setter String productType;
    @Getter @Setter String services;
    @Getter @Setter boolean skeleton;
    @Getter @Setter String pickupDate;
    @Getter @Setter String receivedAt;
    @Getter @Setter int pieces;
    @Getter @Setter double hawbWeight;
    @Getter @Setter double chargeableWeight;
    @Getter @Setter String hawbWeightUnit;
    @Getter @Setter String paymentType;
    @Getter @Setter double collectAmount;
    @Getter @Setter String collectCurrencyCode;
    @Getter @Setter double customsAmount;
    @Getter @Setter String customsCurrencyCode;
    @Getter @Setter String commodityCountryCode;
    @Getter @Setter String commodityDescription;
    @Getter @Setter String billingAccountNumber;
    @Getter @Setter long sourceId;
    @Getter @Setter String hawbRemarks;
    @Getter @Setter double cashValue;
    @Getter @Setter String cashCurrencyCode;
    @Getter @Setter double insuranceValue;
    @Getter @Setter String insuranceCurrencyCode;
    @Getter @Setter double codValue;
    @Getter @Setter String codCurrencyCode;
    @Getter @Setter String paymentOption;
    @Getter @Setter String srnNumber;
    @Getter @Setter String hawbProductGroup;
    @Getter @Setter String hawbRef1;
    @Getter @Setter String hawbRef2;
    @Getter @Setter String hawbRef3;
    @Getter @Setter String hawbAlertedBy;
    @Getter @Setter String hawbAlertedDate;
    @Getter @Setter String dueDate;
    @Getter @Setter String collectionReference;
    @Getter @Setter double cube;
    @Getter @Setter String cubeUnit;
    @Getter @Setter String accountingInformation;
    @Getter @Setter long prepaidRangeId;
    @Getter @Setter HawbDimensions hawbDimensions;
    @Getter @Setter AdditionalProperties additionalProperties;
//    Shipper shipper;
//    Receiver receiver;
//    ThirdParty thirdParty;
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

  public static class Geo {

    @Getter @Setter String type;
    @Getter @Setter double[] coordinates;

  }

  public static class HawbDimensions {

    @Getter @Setter Dim dim;

    public static class Dim {

      @Getter @Setter int wf;
      @Getter @Setter String wu;
      @Getter @Setter String[] p;
      @Getter @Setter String[] l;
      @Getter @Setter String[] w;
      @Getter @Setter String[] h;
      @Getter @Setter String[] gw;
      @Getter @Setter String[] vw;
      @Getter @Setter String[] cw;
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

  public static class AdditionalProperties {

    @Getter @Setter ShipmentProfile shipmentProfile;

    public static class ShipmentProfile {

      @Getter @Setter String brandName;
      @Getter @Setter String businessType;
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

