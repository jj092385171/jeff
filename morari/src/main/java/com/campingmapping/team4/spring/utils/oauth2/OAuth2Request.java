package com.campingmapping.team4.spring.utils.oauth2;

import lombok.Getter;

import java.security.AuthProvider;
import java.util.Optional;

// Oauth2登入後拿取
@Getter
public class OAuth2Request {
  private String accountId;
  private Optional<String> name;
  private Optional<String> email;
  private AuthProvider provider;

  public OAuth2Request(String accountId, String name, String email, AuthProvider provider) {
    this.accountId = accountId;
    this.name = Optional.ofNullable(name);
    this.email = Optional.ofNullable(email);
    this.provider = provider;
  }
}
