package com.pratham.studentapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
                "message", "studentapi is running",
                "health", "/actuator/health",
                "docs", "/swagger-ui/index.html"
        );
    }
}
