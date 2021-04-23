package com.example.rabbitserver.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit/quickStart")
public class QuickStartController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/test")
    public String quickStart() {
        String routingKey = "QUICK_START";
        for (int i = 0; i < 10000; i++) {
            rabbitTemplate.convertAndSend(routingKey, "这是第 " + i + " 条消息");
        }
        return "test";
    }
}
