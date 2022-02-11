package com.example.helloserver.design.pattern.duty;

import com.example.helloserver.dto.design.duty.OrderRootDTO;

public class HandlerB extends AbstractHandler {

    public HandlerB(AbstractHandler successor) {
        super(successor);
    }

    @Override
    public Boolean handleRequest(OrderRootDTO rootDTO) {
        Integer totalAmount = rootDTO.getHeader().getTotalAmount();
        if (totalAmount <= 0) {
            throw new RuntimeException("金额错误，需要大于0");
        }
        if (this.successor != null) {
            this.successor.handleRequest(rootDTO);
        }
        return true;
    }
}
