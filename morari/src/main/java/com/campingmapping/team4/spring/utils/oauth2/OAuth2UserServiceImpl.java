package com.campingmapping.team4.spring.utils.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.entity.AuthProvider;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.utils.oauth2.attributemapper.AttributeMapper;
import com.campingmapping.team4.spring.utils.oauth2.authaccount.entity.AuthAccount;
import com.campingmapping.team4.spring.utils.oauth2.authaccount.mapper.AuthAccountMapper;
import com.campingmapping.team4.spring.utils.oauth2.authaccount.service.AuthAccountService;

import java.util.Map;

// OAuth帳號認證後 如果有存在則拿取帳戶 如果沒存在則新增帳戶
@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImpl extends DefaultOAuth2UserService {
  private final AttributeMapper attributeMapper;
  private final AuthAccountService authAccountService;
  private final AuthAccountMapper authAccountMapper;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    // 尋找是哪的服務
    AuthProvider authProvider = AuthProvider.valueOf(userRequest.getClientRegistration().getClientName().toUpperCase());
    OAuth2User oAuth2User = super.loadUser(userRequest);
    OAuth2Request oAuth2Request = attributeMapper.mapToUser(authProvider, oAuth2User.getAttributes());
    authAccountService.createIfFirst(oAuth2Request);
    UserProfiles user = authAccountService.findByAccountId(oAuth2Request.accountId());
    Map<String, Object> userAttributes = authAccountMapper.mapToAttributeMap(user);

    return new DefaultOAuth2User(user.getRoles(), userAttributes, "id");
  }
}
