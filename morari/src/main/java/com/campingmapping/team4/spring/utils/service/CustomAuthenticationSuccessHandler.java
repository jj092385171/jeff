package com.campingmapping.team4.spring.utils.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // 登入前先檢查是否有 下個路徑的cookie 存在
        Cookie[] cookies = request.getCookies();
        String targetUrl = "/default";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("targetUrl")) {
                    targetUrl = cookie.getValue();
                    break;
                }
            }
        }
        response.sendRedirect(targetUrl);

    }

}