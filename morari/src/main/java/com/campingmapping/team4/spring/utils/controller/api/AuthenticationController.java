package com.campingmapping.team4.spring.utils.controller.api;

import lombok.RequiredArgsConstructor;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationRequest;
import com.campingmapping.team4.spring.t401member.model.dto.RegisterRequest;
import com.campingmapping.team4.spring.utils.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<Void> register(
      @RequestBody RegisterRequest request, HttpServletResponse response) throws IOException {

    if (service.register(request)) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
      // 回傳409表示衝突
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

  }

  @PostMapping("/authenticate")
  public ResponseEntity<Void> authenticate(
      @RequestBody AuthenticationRequest request, HttpServletResponse response) {
    if (service.authenticate(request, response)) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } else {
      // 驗證失敗
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

  }

  @PostMapping("/state")
  public Boolean loginstate(
      HttpServletRequest request) {
    return service.loginstate(request);
  }

  // @PostMapping("/logout")
  // public void logout(HttpServletResponse response) throws IOException {
  // // 處理登出邏輯，例如清除session、Cookie等
  // Cookie jwtCookie = new Cookie(MyConstants.JWT_COOKIE_NAME, null);
  // jwtCookie.setPath("/");
  // jwtCookie.setHttpOnly(true);
  // jwtCookie.setSecure(true);
  // response.addCookie(jwtCookie);

  // // 重定向到登入頁面
  // response.sendRedirect("/morari");
  // }
  

}
