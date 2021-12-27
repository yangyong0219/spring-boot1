package com.example.leetcodeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LeetcodeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetcodeServerApplication.class, args);
    }

}
