package com.example.helloserver.design.pattern.duty;

import com.example.helloserver.dto.design.duty.OrderRootDTO;

public abstract class AbstractHandler {
    protected AbstractHandler successor;

    public AbstractHandler(AbstractHandler successor) {
        this.successor = successor;
    }

    public abstract Boolean handleRequest(OrderRootDTO rootDTO);
}
