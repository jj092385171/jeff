package com.alibou.security.auth;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
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
  public ResponseEntity<Void> register(
      @RequestBody RegisterRequest request, HttpServletResponse response) {

    System.out.println("註冊");

    AuthenticationResponse authenticationResponse = service.register(request);
    Cookie jwtCookie = new Cookie("sigin", authenticationResponse.getToken());
    jwtCookie.setPath("/");
    System.out.println(jwtCookie.getValue());

    jwtCookie.setHttpOnly(true);
    response.addCookie(jwtCookie);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/authenticate")
  public ResponseEntity<Void> authenticate(
      @RequestBody AuthenticationRequest request, HttpServletResponse response) {

    System.out.println(service.authenticate(request));
    System.out.println("登入");

    AuthenticationResponse authenticationResponse = service.authenticate(request);
    Cookie jwtCookie = new Cookie("sigin", authenticationResponse.getToken());
    jwtCookie.setPath("/");

    System.out.println(jwtCookie.getValue());

    jwtCookie.setHttpOnly(true);
    response.addCookie(jwtCookie);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}
