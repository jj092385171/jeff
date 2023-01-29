package com.campingmapping.team4.spring.utils.oauth2.attributemapper;

import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.utils.oauth2.OAuth2Request;

import java.security.AuthProvider;
import java.util.Map;

/**
 * @author Hyeonjun Park
 */
@Component
public class GoogleAttributeMapper implements AttributeMappable {
  @Override
  public OAuth2Request mapToDTO(Map<String, Object> attributes) {
    String accountId = (String) attributes.get("sub");
    String name = (String) attributes.get("name");
    String email = (String) attributes.get("nickname");
    return new OAuth2Request(accountId, name, email, AuthProvider.GOOGLE);
  }
}
