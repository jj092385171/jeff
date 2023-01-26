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

import io.jsonwebtoken.ExpiredJwtException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;

  // private final AuthAspect authAspect;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    final String jwt;
    final String userEmail;

    boolean needAuth = false;

    if (request.getRequestURI().equals("/morari/admin")) {
      needAuth = true;
    }
    if (!needAuth) {
      filterChain.doFilter(request, response);
      return;
    }

    System.out.println("auth");

    Cookie[] cookies = request.getCookies();
    String cookiejwt = null;
    if (cookies != null) {
      cookiejwt = Arrays.stream(cookies)
          .filter(c -> c.getName().equals(MyConstants.JWT_COOKIE_NAME))
          .map(Cookie::getValue)
          .findFirst()
          .orElse(null);
    }
    if (cookiejwt == null || cookiejwt.isEmpty()) {
      filterChain.doFilter(request, response);
      return;
    }
    jwt = cookiejwt;

    try {
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
      Cookie jwtCookie = new Cookie(MyConstants.JWT_COOKIE_NAME, cookiejwt);
      jwtCookie.setHttpOnly(true);
      jwtCookie.setSecure(true);
      jwtCookie.setPath("/");
      response.addCookie(jwtCookie);
      filterChain.doFilter(request, response);
    } catch (ExpiredJwtException e) {
      // 刪除 JWT cookie
      e.printStackTrace();
      Cookie jwtCookie = new Cookie(MyConstants.JWT_COOKIE_NAME, null);
      jwtCookie.setMaxAge(1000 * 60 * 24);
      jwtCookie.setHttpOnly(true);
      jwtCookie.setSecure(true);
      jwtCookie.setPath("/");
      response.addCookie(jwtCookie);
      response.sendRedirect("/morari/home");
    }
  }

}
