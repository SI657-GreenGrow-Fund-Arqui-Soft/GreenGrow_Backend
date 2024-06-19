package com.greengrow.backend.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/articlesFallback")
    public ResponseEntity<String> articlesFallback() {
        return ResponseEntity.status(500).body("Articles Service is currently unavailable. Please try again later");
    }

    @RequestMapping("/coursesFallback")
    public ResponseEntity<String> coursesFallback() {
        return ResponseEntity.status(500).body("Courses Service is currently unavailable. Please try again later");
    }

    @RequestMapping("/postsFallback")
    public ResponseEntity<String> postsFallback() {
        return ResponseEntity.status(500).body("Posts Service is currently unavailable. Please try again later");
    }

    @RequestMapping("/profilesFallback")
    public ResponseEntity<String> profilesFallback() {
        return ResponseEntity.status(500).body("Profiles Service is currently unavailable. Please try again later");
    }

    @RequestMapping("/trendsFallback")
    public ResponseEntity<String> trendsFallback() {
        return ResponseEntity.status(500).body("Trends Service is currently unavailable. Please try again later");
    }
}
