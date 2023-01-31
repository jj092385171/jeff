package com.campingmapping.team4.spring.utils.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationResponse;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// OAuth2 成功登入執行
@Component
@RequiredArgsConstructor
public class OAuth2AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  private final UserRepository userRepository;
  private final JwtService jwtService;

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {
    // 拿取用戶資料
    System.out.println("=====================================");
    System.out.println(authentication.getPrincipal().toString());
    System.out.println("=====================================");
    System.out.println(authentication.getDetails().toString());
    System.out.println("=====================================");
    System.out.println(authentication.getName());
    System.out.println("=====================================");
    System.out.println(authentication.toString());
    System.out.println("=====================================");
    System.out.println(authentication.getPrincipal());
    System.out.println("O2U=====================================");
    OAuth2User a = (OAuth2User) authentication.getPrincipal();
    System.out.println(a.getName());
    System.out.println(a.getAttributes().get("email"));
    System.out.println("=====================================");

    //  User Attributes: [{   given_name=育群, locale=zh-TW,  name=施育群, family_name=施,  email=suc12345@gmail.com}]

    UserProfiles userProfiles = getOAuthUser((OAuth2User) authentication.getPrincipal());
    AuthenticationResponse authenticationResponse = jwtService.generateToken(userProfiles,
        false);
    jwtService.refreshTokenToCookie(response, authenticationResponse);
    // 重新導向
    response.sendRedirect("/home");
  }

  private UserProfiles getOAuthUser(OAuth2User oAuth2User) {
    return userRepository.findByEmail(oAuth2User.getAttribute("email")).orElseThrow();
  }
}
