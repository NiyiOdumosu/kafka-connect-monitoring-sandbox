package shipment.tracking.transformer.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "HAWBUpdate")
public class Tracking {

  public long getHawbId() {
    return hawbId;
  }

  public void setHawbId(long hawbId) {
    this.hawbId = hawbId;
  }

  public String getHawbNumber() {
    return hawbNumber;
  }

  public void setHawbNumber(String hawbNumber) {
    this.hawbNumber = hawbNumber;
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

  public double getGeoLongitude() {
    return geoLongitude;
  }

  public void setGeoLongitude(double geoLongitude) {
    this.geoLongitude = geoLongitude;
  }

  public double getGeoLatitude() {
    return geoLatitude;
  }

  public void setGeoLatitude(double geoLatitude) {
    this.geoLatitude = geoLatitude;
  }

  public String getSourceId() {
    return sourceId;
  }

  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
  }

  public HawbDetails getHawbDetails() {
    return hawbDetails;
  }

  public void setHawbDetails(HawbDetails hawbDetails) {
    this.hawbDetails = hawbDetails;
  }

  public MawbDetails getMawbDetails() {
    return mawbDetails;
  }

  public void setMawbDetails(MawbDetails mawbDetails) {
    this.mawbDetails = mawbDetails;
  }

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
  String sourceId;
  @JacksonXmlProperty(localName = "HAWBDetails")
  HawbDetails hawbDetails;
  @JacksonXmlProperty(localName = "MAWBDetails")
  MawbDetails mawbDetails;

  public static class HawbDetails {

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
    String hawbDimensionsXmlString;

    HawbDimensions hawbDimensions;

    public void setHawbDimensions(HawbDimensions hawbDimensions) {
      this.hawbDimensions = hawbDimensions;
    }

    public HawbDimensions getHawbDimensions() {
      return hawbDimensions;
    }

    @JacksonXmlProperty(localName = "AdditionalProperties")
    AdditionalProperties additionalProperties;

    public String getHawbNumber() {
      return hawbNumber;
    }

    public String getForeignHawbNumber() {
      return foreignHawbNumber;
    }

    public String getHawbOriginEntity() {
      return hawbOriginEntity;
    }

    public String getHawbDestinationEntity() {
      return hawbDestinationEntity;
    }

    public String getProductType() {
      return productType;
    }

    public String getServices() {
      return services;
    }

    public boolean isSkeleton() {
      return skeleton;
    }

    public String getPickupDate() {
      return pickupDate;
    }

    public String getReceivedAt() {
      return receivedAt;
    }

    public int getPieces() {
      return pieces;
    }

    public double getHawbWeight() {
      return hawbWeight;
    }

    public String getHawbWeightUnit() {
      return hawbWeightUnit;
    }

    public double getChargeableWeight() {
      return chargeableWeight;
    }

    public String getPaymentType() {
      return paymentType;
    }

    public double getCollectAmount() {
      return collectAmount;
    }

    public String getCollectCurrencyCode() {
      return collectCurrencyCode;
    }

    public double getCustomsAmount() {
      return customsAmount;
    }

    public String getCustomsCurrencyCode() {
      return customsCurrencyCode;
    }

    public String getCommodityCountryCode() {
      return commodityCountryCode;
    }

    public String getCommodityDescription() {
      return commodityDescription;
    }

    public String getBillingAccountNumber() {
      return billingAccountNumber;
    }

    public String getShipperNumber() {
      return shipperNumber;
    }

    public String getShipperReference() {
      return shipperReference;
    }

    public String getShipperName() {
      return shipperName;
    }

    public String getSentBy() {
      return sentBy;
    }

    public String getShipperAddress() {
      return shipperAddress;
    }

    public String getShipperAddress2() {
      return shipperAddress2;
    }

    public String getShipperTelephone() {
      return shipperTelephone;
    }

    public String getShipperCity() {
      return shipperCity;
    }

    public String getShipperStateCode() {
      return shipperStateCode;
    }

    public String getShipperZipCode() {
      return shipperZipCode;
    }

    public String getShipperCountryCode() {
      return shipperCountryCode;
    }

    public long getShipperId() {
      return shipperId;
    }

    public long getShipperTeamId() {
      return shipperTeamId;
    }

    public String getShipperReference2() {
      return shipperReference2;
    }

    public String getShipperFax() {
      return shipperFax;
    }

    public String getShipperEmail() {
      return shipperEmail;
    }

    public String getShipperMobile() {
      return shipperMobile;
    }

    public String getConsigneeNumber() {
      return consigneeNumber;
    }

    public String getConsigneeReference() {
      return consigneeReference;
    }

    public String getConsigneeName() {
      return consigneeName;
    }

    public String getConsigneeAttentionOf() {
      return consigneeAttentionOf;
    }

    public String getConsigneeAddress() {
      return consigneeAddress;
    }

    public String getConsigneeAddress2() {
      return consigneeAddress2;
    }

    public String getConsigneeTelephone() {
      return consigneeTelephone;
    }

    public String getConsigneeTelephone2() {
      return consigneeTelephone2;
    }

    public String getConsigneeCity() {
      return consigneeCity;
    }

    public String getConsigneeStateCode() {
      return consigneeStateCode;
    }

    public String getConsigneeZipCode() {
      return consigneeZipCode;
    }

    public String getConsigneeCountryCode() {
      return consigneeCountryCode;
    }

    public long getConsigneeId() {
      return consigneeId;
    }

    public long getConsigneeTeamId() {
      return consigneeTeamId;
    }

    public String getConsigneeReference2() {
      return consigneeReference2;
    }

    public String getConsigneeFax() {
      return consigneeFax;
    }

    public String getConsigneeEmail() {
      return consigneeEmail;
    }

    public String getConsigneeMobile() {
      return consigneeMobile;
    }

    public String getThirdPartynumber() {
      return thirdPartynumber;
    }

    public String getThirdPartyReference() {
      return thirdPartyReference;
    }

    public String getThirdPartyName() {
      return thirdPartyName;
    }

    public String getThirdPartyContact() {
      return thirdPartyContact;
    }

    public String getThirdPartyAddress() {
      return thirdPartyAddress;
    }

    public String getThirdPartyAddress2() {
      return thirdPartyAddress2;
    }

    public String getThirdPartyTelephone() {
      return thirdPartyTelephone;
    }

    public String getThirdPartyCity() {
      return thirdPartyCity;
    }

    public String getThirdPartyStateCode() {
      return thirdPartyStateCode;
    }

    public String getThirdPartyZipCode() {
      return thirdPartyZipCode;
    }

    public String getThirdPartyCountryCode() {
      return thirdPartyCountryCode;
    }

    public long getThirdPartyId() {
      return thirdPartyId;
    }

    public long getThirdPartyTeamId() {
      return thirdPartyTeamId;
    }

    public String getThirdPartyEntity() {
      return thirdPartyEntity;
    }

    public String getThirdPartyReference2() {
      return thirdPartyReference2;
    }

    public long getSourceId() {
      return sourceId;
    }

    public String getHawbRemarks() {
      return hawbRemarks;
    }

    public double getCashValue() {
      return cashValue;
    }

    public String getCashCurrencyCode() {
      return cashCurrencyCode;
    }

    public double getInsuranceValue() {
      return insuranceValue;
    }

    public String getInsuranceCurrencyCode() {
      return insuranceCurrencyCode;
    }

    public double getCodValue() {
      return codValue;
    }

    public String getCodCurrencyCode() {
      return codCurrencyCode;
    }

    public String getPaymentOption() {
      return paymentOption;
    }

    public String getSrnNumber() {
      return srnNumber;
    }

    public String getHawbProductGroup() {
      return hawbProductGroup;
    }

    public String getOriginLocationCode() {
      return originLocationCode;
    }

    public String getDestinationLocationCode() {
      return destinationLocationCode;
    }

    public String getHawbRef1() {
      return hawbRef1;
    }

    public String getHawbRef2() {
      return hawbRef2;
    }

    public String getHawbRef3() {
      return hawbRef3;
    }

    public String getHawbAlertedBy() {
      return hawbAlertedBy;
    }

    public String getHawbAlertedDate() {
      return hawbAlertedDate;
    }

    public String getDueDate() {
      return dueDate;
    }

    public String getCollectionReference() {
      return collectionReference;
    }

    public double getCube() {
      return cube;
    }

    public String getCubeUnit() {
      return cubeUnit;
    }

    public String getAccountingInformation() {
      return accountingInformation;
    }

    public long getPrepaidRangeId() {
      return prepaidRangeId;
    }

    public String getHawbDimensionsXmlString() {
      return hawbDimensionsXmlString;
    }

    public AdditionalProperties getAdditionalProperties() {
      return additionalProperties;
    }
  }

  static class MawbDetails {

    public String getCarrier() {
      return carrier;
    }

    public String getOriginPoint() {
      return originPoint;
    }

    public String getMawbNumber() {
      return mawbNumber;
    }

    public String getDestinationPort() {
      return destinationPort;
    }

    public int getOriginEntity() {
      return originEntity;
    }

    public String getDestinationEntity() {
      return destinationEntity;
    }

    public String getFlt1Carrier() {
      return flt1Carrier;
    }

    public String getFlt1Number() {
      return flt1Number;
    }

    public String getFlt1Etd() {
      return flt1Etd;
    }

    public String getFlt1Eta() {
      return flt1Eta;
    }

    public String getVia1() {
      return via1;
    }

    public String getFlt2Carrier() {
      return flt2Carrier;
    }

    public String getFlt2Number() {
      return flt2Number;
    }

    public String getFlt2Etd() {
      return flt2Etd;
    }

    public String getFlt2Eta() {
      return flt2Eta;
    }

    public String getVia2() {
      return via2;
    }

    public String getFlt3Carrier() {
      return flt3Carrier;
    }

    public String getFlt3Number() {
      return flt3Number;
    }

    public String getFlt3Etd() {
      return flt3Etd;
    }

    public String getFlt3Eta() {
      return flt3Eta;
    }

    public String getNetEta() {
      return netEta;
    }

    public int getMotherBags() {
      return motherBags;
    }

    public int getBabyBags() {
      return babyBags;
    }

    public double getMawbWeight() {
      return mawbWeight;
    }

    public String getMawbWeighUnit() {
      return mawbWeighUnit;
    }

    public String getRemarks() {
      return remarks;
    }

    public String getOriginEntityCode() {
      return originEntityCode;
    }

    public String getDestinationEntityCode() {
      return destinationEntityCode;
    }

    public boolean isMawbRecoveryNotRequired() {
      return mawbRecoveryNotRequired;
    }

    public String getMawbContainerNumber() {
      return mawbContainerNumber;
    }

    public String getFinalizedDate() {
      return finalizedDate;
    }

    public long getContractfltGrpsId() {
      return contractfltGrpsId;
    }

    public long getSrrId() {
      return srrId;
    }

    public long getMawbId() {
      return mawbId;
    }

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
    public ShipmentProfile getShipmentProfile() {
      return shipmentProfile;
    }

    @JacksonXmlProperty(localName = "ShipmentProfile")
    ShipmentProfile shipmentProfile;


    static class ShipmentProfile {
      public String getBrandName() {
        return brandName;
      }

      public String getBusinessType() {
        return businessType;
      }

      @JacksonXmlProperty(localName = "BrandName")
      String brandName;
      @JacksonXmlProperty(localName = "BusinessType")
      String businessType;
    }
  }
}

