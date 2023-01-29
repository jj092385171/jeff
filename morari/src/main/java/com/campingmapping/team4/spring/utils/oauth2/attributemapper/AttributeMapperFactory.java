package com.campingmapping.team4.spring.utils.oauth2.attributemapper;

import org.springframework.stereotype.Component;

import java.security.AuthProvider;
import java.util.EnumMap;
import java.util.Map;

/**
 * 각 소셜 별로 Mapper을 생성해서 제공하는 Factory
 *
 * @author Hyeonjun Park
 */
@Component
public class AttributeMapperFactory {
  private final Map<AuthProvider, AttributeMappable> mapperMap = new EnumMap<>(AuthProvider.class);
  private final GoogleAttributeMapper googleAttributeMapper;

  public AttributeMapperFactory(
      GoogleAttributeMapper googleAttributeMapper) {
    this.googleAttributeMapper = googleAttributeMapper;

    initialize();
  }

  private void initialize() {
    mapperMap.put(AuthProvider.GOOGLE, googleAttributeMapper);

  }

  public AttributeMappable get(AuthProvider authProvider) {
    return mapperMap.get(authProvider);
  }
}
