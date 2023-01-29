package com.campingmapping.team4.spring.utils.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

private UserRepository userRepository;

@Override
public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
// 取得使用者資訊並存入資料庫
Object a = authentication.getPrincipal();


// userRepository.save(userProfiles);
// 轉跳到首頁
response.sendRedirect("/");
}
}
