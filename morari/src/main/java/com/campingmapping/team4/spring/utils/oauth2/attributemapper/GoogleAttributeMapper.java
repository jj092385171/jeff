package com.campingmapping.team4.spring.utils.oauth2.attributemapper;

import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t401member.model.entity.AuthProvider;
import com.campingmapping.team4.spring.utils.oauth2.OAuth2Request;

import java.util.Map;
import java.util.Optional;


@Component
public class GoogleAttributeMapper implements AttributeMappable {
  @Override
  public OAuth2Request mapToDTO(Map<String, Object> attributes) {
    String accountId = (String) attributes.get("sub");
    String name = (String) attributes.get("name");
    String email = (String) attributes.get("email");
    return new OAuth2Request(accountId, Optional.ofNullable(name), Optional.ofNullable(email), AuthProvider.GOOGLE);
  }
}
