package com.salary.filter;

import com.salary.dto.Result;
import com.salary.util.JsonUtil;
import com.salary.util.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Resource
    private JwtUtil jwtUtil;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            writeJsonResponse(response, Result.failed("缺少令牌"));
            return;
        }

        String token = authHeader.substring(7);
        String username = jwtUtil.validateTokenAndGetUsername(token);

        if (username == null) {
            writeJsonResponse(response, Result.failed("无效或过期的令牌"));
            return;
        }

        request.setAttribute("username", username);
        filterChain.doFilter(request, response);
    }

    private void writeJsonResponse(HttpServletResponse response, Result<?> result) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 状态码
        response.getWriter().write(JsonUtil.toJson(result));
    }
}

