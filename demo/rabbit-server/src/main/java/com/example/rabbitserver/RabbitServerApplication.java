package com.example.rabbitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitServerApplication.class, args);
    }

}
