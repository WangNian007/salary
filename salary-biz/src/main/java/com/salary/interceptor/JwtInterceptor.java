package com.salary.interceptor;

import com.salary.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setContentType("application/json;charset=UTF-8");  // 根据实际内容调整类型
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("缺少或错误的 Authorization 头");
            return false;
        }

        String token = authHeader.substring(7);
        try {
            Claims claims = JwtUtil.parseToken(token);
            response.setContentType("application/json;charset=UTF-8");  // 根据实际内容调整类型
            request.setAttribute("username", claims.getSubject());
            return true;
        } catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");  // 根据实际内容调整类型
            response.getWriter().write("无效或过期的 Token");
            return false;
        }
    }
}