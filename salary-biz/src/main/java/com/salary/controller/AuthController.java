package com.salary.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.salary.dto.LoginDTO;
import com.salary.service.ISysUserService;
import com.salary.util.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private ISysUserService sysUserService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private DefaultKaptcha kaptcha;

    @Resource
    private JwtUtil jwtUtil;


    private boolean checkUser(String username, String password) {
        // 这里模拟验证，真实情况从数据库查
        return "user".equals(username) && "123456".equals(password);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {
        String cachedCaptcha = stringRedisTemplate.opsForValue().get("captcha:" + request.getCaptchaId());
        if (cachedCaptcha == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("验证码已过期");
        }
        if (!cachedCaptcha.equalsIgnoreCase(request.getCaptcha())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("验证码错误");
        }

        stringRedisTemplate.delete("captcha:" + request.getCaptchaId());

        if (!checkUser(request.getUsername(), request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
        }

        String token = jwtUtil.generateToken(request.getUsername());

        return ResponseEntity.ok(token);
    }


    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response, @RequestParam String uuid) throws IOException {
        String text = kaptcha.createText();

        stringRedisTemplate.opsForValue().set("captcha:" + uuid, text, 5, TimeUnit.MINUTES);
        BufferedImage image = kaptcha.createImage(text);
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.flush();
        out.close();
    }


}
