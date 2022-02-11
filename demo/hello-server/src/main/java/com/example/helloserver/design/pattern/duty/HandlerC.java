package com.example.helloserver.design.pattern.duty;

import com.example.helloserver.dto.design.duty.OrderRootDTO;

public class HandlerC extends AbstractHandler {

    public HandlerC(AbstractHandler successor) {
        super(successor);
    }

    @Override
    public Boolean handleRequest(OrderRootDTO rootDTO) {
        String orderType = rootDTO.getHeader().getSendType();
        if (!"CREATE".equals(orderType)) {
            throw new RuntimeException("操作类型错误，需要为CREATE");
        }
        if (this.successor != null) {
            this.successor.handleRequest(rootDTO);
        }
        return true;
    }
}
