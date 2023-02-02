package com.campingmapping.team4.spring.utils.service.attributemapper;

import java.util.Map;

import com.campingmapping.team4.spring.t401member.model.entity.OAuth2Request;

/**
 * 소셜 로그인시 Attribute 값을 dto로 mapping 하는 interface
 *
 * @author Hyeonjun Park
 */
public interface AttributeMappable {
  OAuth2Request mapToDTO(Map<String, Object> attributes);
}
