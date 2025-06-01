package com.salary.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return "Hello, " + username + "! 这是受保护的接口。";
    }
}
