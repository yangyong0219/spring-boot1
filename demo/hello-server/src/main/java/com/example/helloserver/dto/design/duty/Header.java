package com.example.helloserver.dto.design.duty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Header {

    private String warehouseCode;
    private String sendType;
    private Integer palletQty;
    private String ladingNo;
    private String licensePlate;
    private String estimatePickUpDate;
    private Shipper shipper;
    private String shippingPaymentType;
    private String dutyPaymentType;
    private String termsOfTrade;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invoiceDate;
    private String invoiceNo;
    private String freightValue;
    private String insuranceValue;
    private Double totalGrossWeight;
    private Integer totalAmount;
    private Integer taxValue;
    private String currency;
    private Integer declaredValue;
    private String shippingPaymentAccount;
    private String dutyPaymentAccount;
    private String goodsName;
    private String orderBatteryModel;
    private String trackingNotes;
    private String trackingAcknowledgement;
    private String informalCustomsClearance;
    private Integer bkLogisticStatus;
    private String finalDestination;
    private String salesOrder;
    private String company;
    private String warehouse;
    private String orderId;
    private String orderType;
    private Long orderDate;
    private String carrier;
    private String carrierMode;
    private String serviceLevel;
    private String remarks;
    private Consignee consignee;


}