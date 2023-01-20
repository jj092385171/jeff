package com.campingmapping.team4.spring.utils.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.campingmapping.team4.spring.utils.service.JwtService;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    final String jwt;
    final String userEmail;
    final String JWTCookieName = "sigin";
    // 存取下個要去路徑的請求加進COOKIE
    String targetUrl = request.getRequestURL().toString();
    Cookie targetUrlCookie = new Cookie("targetUrl", targetUrl);
    targetUrlCookie.setPath("/");
    response.addCookie(targetUrlCookie);

    Cookie[] cookies = request.getCookies();
    String cookiejwt = null;
    if (cookies != null) {
      cookiejwt = Arrays.stream(cookies)
          .filter(c -> c.getName().equals(JWTCookieName))
          .map(Cookie::getValue)
          .findFirst()
          .orElse(null);
    }
    if (cookiejwt == null || cookiejwt.isEmpty()) {
      filterChain.doFilter(request, response);
      return;
    }
    jwt = cookiejwt;
    userEmail = jwtService.extractUsername(jwt);
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
      if (jwtService.isTokenValid(jwt, userDetails)) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            userDetails,
            null,
            userDetails.getAuthorities());
        authToken.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }
    Cookie jwtcookie = new Cookie(JWTCookieName, cookiejwt);
    jwtcookie.setHttpOnly(true);
    jwtcookie.setPath("/");
    response.addCookie(jwtcookie);
    filterChain.doFilter(request, response);
  }

}
