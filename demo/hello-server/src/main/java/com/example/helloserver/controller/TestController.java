package com.example.helloserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    private static final List<String> list = new ArrayList<>();
    @PostMapping("/test")
    public String testHello(@RequestBody String str) {
        System.out.println(str);
        for (int i = 0; i < 1000; i++) {
            String s = "" + i;
            list.add(s);
            logger.info(s);
        }
        logger.info(str);
        return list.size() + "";
    }
}
