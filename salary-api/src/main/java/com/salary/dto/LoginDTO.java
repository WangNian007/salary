package com.salary.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;
    private String captchaId;
    private String captcha;
}
