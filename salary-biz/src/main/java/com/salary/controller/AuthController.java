package com.salary.controller;

import com.salary.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 模拟校验
        if ("admin".equals(username) && "123456".equals(password)) {
            return JwtUtil.generateToken(username);
        }
        throw new RuntimeException("用户名或密码错误");
    }
}
