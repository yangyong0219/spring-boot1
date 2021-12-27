package com.example.helloserver.designPattern.duty;

import com.example.helloserver.dto.design.duty.OrderRootDTO;

public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    public abstract Boolean handleRequest(OrderRootDTO rootDTO);
}
