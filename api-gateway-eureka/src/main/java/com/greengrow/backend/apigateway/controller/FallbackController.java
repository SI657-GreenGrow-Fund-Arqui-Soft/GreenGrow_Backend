package com.greengrow.backend.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/articlesFallback")
    public String articlesFallback() {
        return "Articles Service is currently unavailable. Please try again later";
    }
}
