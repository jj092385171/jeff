package com.campingmapping.team4.spring.utils.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.campingmapping.team4.spring.utils.service.JwtService;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  @Autowired
  private final JwtService jwtService;
  @Autowired
  private final UserDetailsService userDetailsService;
  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    boolean needAuth = false;
    // 路徑是否需要驗證
    if (request.getRequestURI().equals("/morari/admin")) {
      needAuth = true;
    }
    if (!needAuth) {
      filterChain.doFilter(request, response);
      return;
    }
    // 進入驗證程序
    jwtService.refreshCheckToken(request, response, filterChain,userDetailsService);

  }
}
