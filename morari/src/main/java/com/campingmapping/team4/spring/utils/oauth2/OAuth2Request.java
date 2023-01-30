package com.campingmapping.team4.spring.utils.oauth2;


import java.util.Optional;
import com.campingmapping.team4.spring.t401member.model.entity.AuthProvider;

// Oauth2登入後拿取
public record OAuth2Request (
  String accountId,
  Optional<String> name,
  Optional<String> email,
  AuthProvider provider){
}
