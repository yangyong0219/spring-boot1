package com.example.helloserver.design.pattern.duty;

import com.example.helloserver.dto.design.duty.OrderRootDTO;

public class HandlerA extends AbstractHandler {
    public HandlerA(AbstractHandler successor) {
        super(successor);
    }

    @Override
    public Boolean handleRequest(OrderRootDTO rootDTO) {
        String orderType = rootDTO.getHeader().getOrderType();
        if (!"10".equals(orderType)) {
            throw new RuntimeException("订单类型错误，需要10");
        }
        if (this.successor != null) {
            this.successor.handleRequest(rootDTO);
        }
        return true;
    }
}
