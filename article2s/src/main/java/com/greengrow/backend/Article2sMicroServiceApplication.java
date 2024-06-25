package com.greengrow.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Article2sMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Article2sMicroServiceApplication.class, args);
    }
}