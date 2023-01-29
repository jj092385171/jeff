package com.campingmapping.team4.spring.utils.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.campingmapping.team4.spring.t401member.model.dto.OAuth2Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// OAuth2 成功登入執行
@Component
@RequiredArgsConstructor
public class OAuth2AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  // private final JwtSetupService jwtSetupService;

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {
    // 拿取用戶資料
    OAuth2Login oAuth2Login = getOAuthUser((OAuth2User) authentication.getPrincipal());
    // jwtSetupService.addJwtTokensInCookie(response, loginUser);
    // 重新導向
    response.sendRedirect("/home");
  }

  private OAuth2Login getOAuthUser(OAuth2User oAuth2User) {
    return new OAuth2Login(oAuth2User.getAttribute("id"), oAuth2User.getAttribute("email"));
  }
}
