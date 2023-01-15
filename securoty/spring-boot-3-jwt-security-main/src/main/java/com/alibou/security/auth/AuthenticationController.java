package com.alibou.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request, HttpServletResponse response) {
    AuthenticationResponse authenticationResponse = service.register(request);
    Cookie jwtCookie = new Cookie("jwt", authenticationResponse.getToken());
    jwtCookie.setHttpOnly(true);
    response.addCookie(jwtCookie);
    return ResponseEntity.ok(authenticationResponse);
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request, HttpServletResponse response) {
    AuthenticationResponse authenticationResponse = service.authenticate(request);
    Cookie jwtCookie = new Cookie("jwt", authenticationResponse.getToken());
    jwtCookie.setHttpOnly(true);
    response.addCookie(jwtCookie);
    return ResponseEntity.ok(authenticationResponse);
  }

}
