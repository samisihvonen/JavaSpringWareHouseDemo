package com.warehouse.demo.security;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;

@Component
public class AccessTokenEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        String content = "{\r\n"
                + "    \"timestamp\": \"" + Instant.now() +"\",\r\n"
                + "    \"status\": 401,\r\n"
                + "    \"error\": \"Invalid Token\",\r\n"
                + "    \"message\": \"No message available\",\r\n"
                + "    \"data\": null\r\n"
                + "}";
        response.setContentType("application/json");
        response.setContentLength(content.length());
        response.getWriter().write(content);

    }
}