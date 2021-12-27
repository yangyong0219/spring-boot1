package com.example.helloserver.dto.design.duty;

import lombok.Data;

@Data
public class OrderRootDTO {

    private Header header;
    private Commodity commodity;
    private Pieces pieces;

}