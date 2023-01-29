package com.campingmapping.team4.spring.utils.oauth2.authaccount.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/test")
public class AuthController {
  @GetMapping("members")
  public String getMembers(Principal principal) {
    return principal.getName();
  }
}
