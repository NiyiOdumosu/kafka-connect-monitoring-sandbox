package shipment.tracking.transformer.json;

public class Tracking {

  long hawbId;

  public String getHawbNumber() {
    return hawbNumber;
  }

  public void setHawbNumber(String hawbNumber) {
    this.hawbNumber = hawbNumber;
  }

  String hawbNumber;

  public long getHawbId() {
    return hawbId;
  }

  public void setHawbId(long hawbId) {
    this.hawbId = hawbId;
  }

  public String getHawbOriginEntity() {
    return hawbOriginEntity;
  }

  public void setHawbOriginEntity(String hawbOriginEntity) {
    this.hawbOriginEntity = hawbOriginEntity;
  }

  public String getForeignHawbNumber() {
    return foreignHawbNumber;
  }

  public void setForeignHawbNumber(String foreignHawbNumber) {
    this.foreignHawbNumber = foreignHawbNumber;
  }

  public int getPieces() {
    return pieces;
  }

  public void setPieces(int pieces) {
    this.pieces = pieces;
  }

  public String getUpdateEntity() {
    return updateEntity;
  }

  public void setUpdateEntity(String updateEntity) {
    this.updateEntity = updateEntity;
  }

  public String getPiNumber() {
    return piNumber;
  }

  public void setPiNumber(String piNumber) {
    this.piNumber = piNumber;
  }

  public String getProblemCode() {
    return problemCode;
  }

  public void setProblemCode(String problemCode) {
    this.problemCode = problemCode;
  }

  public String getComment1() {
    return comment1;
  }

  public void setComment1(String comment1) {
    this.comment1 = comment1;
  }

  public String getComment2() {
    return comment2;
  }

  public void setComment2(String comment2) {
    this.comment2 = comment2;
  }

  public String getActionDate() {
    return actionDate;
  }

  public void setActionDate(String actionDate) {
    this.actionDate = actionDate;
  }

  public String getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(String entryDate) {
    this.entryDate = entryDate;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public long getBranchId() {
    return branchId;
  }

  public void setBranchId(long branchId) {
    this.branchId = branchId;
  }


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

  public Geo getGeo() {
    return geo;
  }

  public void setGeo(Geo geo) {
    this.geo = geo;
  }

  Geo geo;

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  String source;

  public HawbDetails getHawbDetails() {
    return hawbDetails;
  }

  public void setHawbDetails(HawbDetails hawbDetails) {
    this.hawbDetails = hawbDetails;
  }

  HawbDetails hawbDetails;
  Mawb mawb;

  public static class HawbDetails {

    public String getHawbNumber() {
      return hawbNumber;
    }

    public void setHawbNumber(String hawbNumber) {
      this.hawbNumber = hawbNumber;
    }

    public String getForeignHawbNumber() {
      return foreignHawbNumber;
    }

    public void setForeignHawbNumber(String foreignHawbNumber) {
      this.foreignHawbNumber = foreignHawbNumber;
    }

    public String getProductType() {
      return productType;
    }

    public void setProductType(String productType) {
      this.productType = productType;
    }

    public String getServices() {
      return services;
    }

    public void setServices(String services) {
      this.services = services;
    }

    public boolean isSkeleton() {
      return skeleton;
    }

    public void setSkeleton(boolean skeleton) {
      this.skeleton = skeleton;
    }

    public String getPickupDate() {
      return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
      this.pickupDate = pickupDate;
    }

    public String getReceivedAt() {
      return receivedAt;
    }

    public void setReceivedAt(String receivedAt) {
      this.receivedAt = receivedAt;
    }

    public int getPieces() {
      return pieces;
    }

    public void setPieces(int pieces) {
      this.pieces = pieces;
    }

    public double getHawbWeight() {
      return hawbWeight;
    }

    public void setHawbWeight(double hawbWeight) {
      this.hawbWeight = hawbWeight;
    }

    public double getChargeableWeight() {
      return chargeableWeight;
    }

    public void setChargeableWeight(double chargeableWeight) {
      this.chargeableWeight = chargeableWeight;
    }

    public String getHawbWeightUnit() {
      return hawbWeightUnit;
    }

    public void setHawbWeightUnit(String hawbWeightUnit) {
      this.hawbWeightUnit = hawbWeightUnit;
    }

    public String getPaymentType() {
      return paymentType;
    }

    public void setPaymentType(String paymentType) {
      this.paymentType = paymentType;
    }

    public double getCollectAmount() {
      return collectAmount;
    }

    public void setCollectAmount(double collectAmount) {
      this.collectAmount = collectAmount;
    }

    public String getCollectCurrencyCode() {
      return collectCurrencyCode;
    }

    public void setCollectCurrencyCode(String collectCurrencyCode) {
      this.collectCurrencyCode = collectCurrencyCode;
    }

    public double getCustomsAmount() {
      return customsAmount;
    }

    public void setCustomsAmount(double customsAmount) {
      this.customsAmount = customsAmount;
    }

    public String getCustomsCurrencyCode() {
      return customsCurrencyCode;
    }

    public void setCustomsCurrencyCode(String customsCurrencyCode) {
      this.customsCurrencyCode = customsCurrencyCode;
    }

    public String getCommodityCountryCode() {
      return commodityCountryCode;
    }

    public void setCommodityCountryCode(String commodityCountryCode) {
      this.commodityCountryCode = commodityCountryCode;
    }

    public String getCommodityDescription() {
      return commodityDescription;
    }

    public void setCommodityDescription(String commodityDescription) {
      this.commodityDescription = commodityDescription;
    }

    public String getBillingAccountNumber() {
      return billingAccountNumber;
    }

    public void setBillingAccountNumber(String billingAccountNumber) {
      this.billingAccountNumber = billingAccountNumber;
    }

    public long getSourceId() {
      return sourceId;
    }

    public void setSourceId(long sourceId) {
      this.sourceId = sourceId;
    }

    public String getHawbRemarks() {
      return hawbRemarks;
    }

    public void setHawbRemarks(String hawbRemarks) {
      this.hawbRemarks = hawbRemarks;
    }

    public double getCashValue() {
      return cashValue;
    }

    public void setCashValue(double cashValue) {
      this.cashValue = cashValue;
    }

    public String getCashCurrencyCode() {
      return cashCurrencyCode;
    }

    public void setCashCurrencyCode(String cashCurrencyCode) {
      this.cashCurrencyCode = cashCurrencyCode;
    }

    public double getInsuranceValue() {
      return insuranceValue;
    }

    public void setInsuranceValue(double insuranceValue) {
      this.insuranceValue = insuranceValue;
    }

    public String getInsuranceCurrencyCode() {
      return insuranceCurrencyCode;
    }

    public void setInsuranceCurrencyCode(String insuranceCurrencyCode) {
      this.insuranceCurrencyCode = insuranceCurrencyCode;
    }

    public double getCodValue() {
      return codValue;
    }

    public void setCodValue(double codValue) {
      this.codValue = codValue;
    }

    public String getCodCurrencyCode() {
      return codCurrencyCode;
    }

    public void setCodCurrencyCode(String codCurrencyCode) {
      this.codCurrencyCode = codCurrencyCode;
    }

    public String getPaymentOption() {
      return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
      this.paymentOption = paymentOption;
    }

    public String getSrnNumber() {
      return srnNumber;
    }

    public void setSrnNumber(String srnNumber) {
      this.srnNumber = srnNumber;
    }

    public String getHawbProductGroup() {
      return hawbProductGroup;
    }

    public void setHawbProductGroup(String hawbProductGroup) {
      this.hawbProductGroup = hawbProductGroup;
    }

    public String getHawbRef1() {
      return hawbRef1;
    }

    public void setHawbRef1(String hawbRef1) {
      this.hawbRef1 = hawbRef1;
    }

    public String getHawbRef2() {
      return hawbRef2;
    }

    public void setHawbRef2(String hawbRef2) {
      this.hawbRef2 = hawbRef2;
    }

    public String getHawbRef3() {
      return hawbRef3;
    }

    public void setHawbRef3(String hawbRef3) {
      this.hawbRef3 = hawbRef3;
    }

    public String getHawbAlertedBy() {
      return hawbAlertedBy;
    }

    public void setHawbAlertedBy(String hawbAlertedBy) {
      this.hawbAlertedBy = hawbAlertedBy;
    }

    public String getHawbAlertedDate() {
      return hawbAlertedDate;
    }

    public void setHawbAlertedDate(String hawbAlertedDate) {
      this.hawbAlertedDate = hawbAlertedDate;
    }

    public String getDueDate() {
      return dueDate;
    }

    public void setDueDate(String dueDate) {
      this.dueDate = dueDate;
    }

    public String getCollectionReference() {
      return collectionReference;
    }

    public void setCollectionReference(String collectionReference) {
      this.collectionReference = collectionReference;
    }

    public double getCube() {
      return cube;
    }

    public void setCube(double cube) {
      this.cube = cube;
    }

    public String getCubeUnit() {
      return cubeUnit;
    }

    public void setCubeUnit(String cubeUnit) {
      this.cubeUnit = cubeUnit;
    }

    public String getAccountingInformation() {
      return accountingInformation;
    }

    public void setAccountingInformation(String accountingInformation) {
      this.accountingInformation = accountingInformation;
    }

    public long getPrepaidRangeId() {
      return prepaidRangeId;
    }

    public void setPrepaidRangeId(long prepaidRangeId) {
      this.prepaidRangeId = prepaidRangeId;
    }

    String hawbNumber;
    String foreignHawbNumber;
    String productType;
    String services;
    boolean skeleton;
    String pickupDate;
    String receivedAt;
    int pieces;
    double hawbWeight;
    double chargeableWeight;
    String hawbWeightUnit;
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
    String hawbAlertedDate;
    String dueDate;
    String collectionReference;
    double cube;
    String cubeUnit;
    String accountingInformation;
    long prepaidRangeId;

    public HawbDimensions getHawbDimensions() {
      return hawbDimensions;
    }

    public void setHawbDimensions(HawbDimensions hawbDimensions) {
      this.hawbDimensions = hawbDimensions;
    }

    HawbDimensions hawbDimensions;
    AdditionalProperties additionalProperties;
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

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    String type;

    public double[] getCoordinates() {
      return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
      this.coordinates = coordinates;
    }

    double[] coordinates;
  }

  public static class HawbDimensions {

    public Dim getDim() {
      return dim;
    }

    public void setDim(Dim dim) {
      this.dim = dim;
    }

    Dim dim;

    public static class Dim {

      public int getWf() {
        return wf;
      }

      public void setWf(int wf) {
        this.wf = wf;
      }

      public String getWu() {
        return wu;
      }

      public void setWu(String wu) {
        this.wu = wu;
      }

      public double[] getP() {
        return p;
      }

      public void setP(double[] p) {
        this.p = p;
      }

      public double[] getL() {
        return l;
      }

      public void setL(double[] l) {
        this.l = l;
      }

      public double[] getW() {
        return w;
      }

      public void setW(double[] w) {
        this.w = w;
      }

      public double[] getH() {
        return h;
      }

      public void setH(double[] h) {
        this.h = h;
      }

      public double[] getGw() {
        return gw;
      }

      public void setGw(double[] gw) {
        this.gw = gw;
      }

      public double[] getVw() {
        return vw;
      }

      public void setVw(double[] vw) {
        this.vw = vw;
      }

      public double[] getCw() {
        return cw;
      }

      public void setCw(double[] cw) {
        this.cw = cw;
      }

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

