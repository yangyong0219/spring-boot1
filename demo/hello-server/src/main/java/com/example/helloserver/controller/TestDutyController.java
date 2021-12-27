package com.example.helloserver.controller;

import com.example.helloserver.designPattern.duty.Handler;
import com.example.helloserver.designPattern.duty.HandlerA;
import com.example.helloserver.designPattern.duty.HandlerB;
import com.example.helloserver.designPattern.duty.HandlerC;
import com.example.helloserver.dto.design.duty.OrderRootDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello/duty")
public class TestDutyController {
    @Autowired
    private ObjectMapper objectMapper;

    @PutMapping("/createOrder")
    public String createOrder(@RequestBody String jsonData) throws JsonProcessingException {
        boolean result;
        try {
            Handler handler = new HandlerA(new HandlerB(new HandlerC(null)));
            OrderRootDTO orderRootDTO = objectMapper.readValue(jsonData, OrderRootDTO.class);
            result = handler.handleRequest(orderRootDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        if (result) {
            return "success";
        } else {
            return "false";
        }
    }
}
