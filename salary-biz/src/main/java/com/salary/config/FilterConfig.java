package com.salary.config;

import com.salary.filter.JwtFilter;
import jakarta.annotation.Resource;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Resource
    private JwtFilter jwtFilter;


    @Bean
    public FilterRegistrationBean<JwtFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtFilter);
        registrationBean.addUrlPatterns("/api/*"); // 只拦截 /api 路径下的请求
        return registrationBean;
    }
}
