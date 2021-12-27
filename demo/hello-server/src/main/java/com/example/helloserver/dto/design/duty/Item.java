package com.example.helloserver.dto.design.duty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Item {

    private Integer itemLineNum;
    private String itemEan;
    private String itemName;
    private String itemDescriptionEn;
    private String itemDescription;
    private Integer qty;
    private String batteryModel;
    private String warehouse;
    private Boolean snFlag;
    private String hSCode;
    private String uom;
    private Integer price;
    private String originCountry;
    private String weightUom;
    private Double weight;
    private Double grossWeight;
    private Integer productType;
    private Boolean hasRemoteController;
    private String tagType;


}