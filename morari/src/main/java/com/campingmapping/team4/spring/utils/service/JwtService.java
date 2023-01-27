package com.campingmapping.team4.spring.utils.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationResponse;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.utils.config.MyConstants;

@Service
public class JwtService {

  private static final String SECRET_KEY = "78214125442A462D4A614E645267556B58703273357638792F423F4528482B4B6250655368566D597133743677397A24432646294A404E635166546A576E5A7234753778214125442A472D4B6150645367556B58703273357638792F423F4528482B4D6251655468576D597133743677397A24432646294A404E635266556A586E327234753778214125442A472D4B6150645367566B59703373367638792F423F4528482B4D6251655468576D5A7134743777217A24432646294A404E635266556A586E3272357538782F413F442A472D4B6150645367566B59703373367639792442264529482B4D6251655468576D5A7134743777217A25432A462D4A614E635266556A586E3272357538782F413F4428472B4B6250655367566B5970337336763979244226452948404D635166546A576D5A7134743777217A25432A462D4A614E645267556B58703272357538782F413F4428472B4B6250655368566D5971337436763979244226452948404D635166546A576E5A7234753778217A25432A462D4A614E645267556B58703273357638792F423F4528472B4B6250655368566D597133743677397A24432646294A404D635166546A576E5A7234753778214125442A472D4B6150645267556B58703273357638792F423F4528482B4D6251655468566D597133743677397A24432646294A404E635266556A586E5A723475";
  private UserDetailsService userDetailsService;

  // 拿取使用者帳號
  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  // 拿取指定內容
  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  // memberMe
  public AuthenticationResponse generateToken(UserDetails userDetails, Boolean rememberMe) {
    return generateToken(new HashMap<>(), userDetails, rememberMe);
  }

  // 製作JWT
  public AuthenticationResponse generateToken(
      Map<String, Object> extraClaims,
      UserDetails userDetails,
      Boolean rememberMe) {
    // 放自定義物件
    UserProfiles userProfile = (UserProfiles) userDetails;
    extraClaims.put("uid", userProfile.getUid());
    extraClaims.put("remember", rememberMe);
    // 製作refreshToken
    String refreshToken = Jwts.builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(
            new Date(System.currentTimeMillis() + (rememberMe ? MyConstants.REMEMBER_REFRESH_TOKEN_VALIDATION_SECOND
                : MyConstants.REFRESH_TOKEN_VALIDATION_SECOND)))
        .signWith(getSignInKey(), SignatureAlgorithm.HS512)
        .compact();
    // 製作accessToken
    String accessToken = Jwts.builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + (MyConstants.ACCESS_TOKEN_VALIDATION_SECOND)))

        .signWith(getSignInKey(), SignatureAlgorithm.HS512)
        .compact();
    return AuthenticationResponse.builder().grantType("bearer").accessToken(accessToken).refreshToken(refreshToken)
        .build();
  }

  // 驗證令牌是否有效
  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
  }

  // 尋找當前使用者的UID
  public Integer getUId(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if (cookies == null || cookies.length == 0) {
      return null;
    }
    String jwt = Arrays.stream(cookies)
        .filter(c -> c.getName().equals(MyConstants.JWT_COOKIE_NAME))
        .map(Cookie::getValue)
        .findFirst()
        .orElse(null);
    if (jwt == null || jwt.isEmpty()) {
      return null;
    }
    Claims claims = extractAllClaims(jwt);
    return (Integer) claims.get("uid");
  }

  // 設置HttpOnly&Https的Cookie
  private Cookie setCookie(String key, String value) {
    Cookie cookie = new Cookie(key, value);
    cookie.setPath("/");
    cookie.setHttpOnly(true);
    cookie.setSecure(true);
    return cookie;
  }

  // 刷新過期令牌
  // public Boolean refreshToken(HttpServletRequest request, HttpServletResponse response) {
  //   AuthenticationResponse authenticationResponse = new AuthenticationResponse();
  //   try {
  //     // 取得access token和refresh token
  //     Cookie[] cookies = request.getCookies();
  //     String accessToken = Arrays.stream(cookies)
  //         .filter(c -> c.getName().equals(MyConstants.JWT_COOKIE_NAME))
  //         .map(Cookie::getValue)
  //         .findFirst()
  //         .orElse(null);
  //     String refreshToken = Arrays.stream(cookies)
  //         .filter(c -> c.getName().equals(MyConstants.JWT_REFRESH_COOKIE_NAME))
  //         .map(Cookie::getValue)
  //         .findFirst()
  //         .orElse(null);
  //     Boolean remember = (Boolean) extractAllClaims(refreshToken).get("remember");

  //     if (accessToken == null || accessToken.isEmpty() || refreshToken == null || refreshToken.isEmpty()) {
  //       return null;
  //     }

  //     String email = extractUsername(accessToken);
  //     UserDetails userDetails = userDetailsService.loadUserByUsername(email);

  //     // 檢查access token是否過期
  //     if (isTokenExpired(accessToken)) {
  //       // 檢查refresh token是否過期
  //       if (isTokenExpired(refreshToken)) {
  //         // 如果access token和refresh token都過期，刪除token
  //         removeToken(response);
  //         return false;
  //       } else {
  //         // 如果access token過期但refresh token還沒過期，刷新token
  //         authenticationResponse = generateToken(userDetails, remember);
  //         refreshTokenToCookie(response, authenticationResponse);
  //         return true;
  //       }
  //     } else {
  //       // 如果access token還沒過期，不處理
  //       return null;
  //     }
  //   } catch (ExpiredJwtException e) {
  //     // access token 已過期
  //     if (e instanceof ExpiredJwtException) {
  //       // 判斷 refresh token 是否過期
  //       // 取得 refresh token
  //       String refreshToken = Arrays.stream(request.getCookies())
  //           .filter(c -> c.getName().equals(MyConstants.JWT_REFRESH_COOKIE_NAME))
  //           .map(Cookie::getValue)
  //           .findFirst()
  //           .orElse(null);
  //       try {
  //         // 驗證 refresh token 是否過期
  //         isTokenExpired(refreshToken);
  //         // refresh token 沒有過期，更新 access token 和 refresh token
  //         UserProfiles userProfiles = findByEmail(extractUsername(refreshToken))
  //             .orElseThrow();
  //         AuthenticationResponse authenticationResponse = generateToken(userProfiles, true);
  //         // 設置新的 access token 和 refresh token
  //         Cookie accessTokenCookie = setCookie(MyConstants.JWT_COOKIE_NAME,
  //             authenticationResponse.getAccessToken());
  //         response.addCookie(accessTokenCookie);
  //         Cookie refreshTokenCookie = setCookie(MyConstants.JWT_REFRESH_COOKIE_NAME,
  //             authenticationResponse.getRefreshToken());
  //         response.addCookie(refreshTokenCookie);
  //       } catch (ExpiredJwtException e2) {
  //         // refresh token 已過期，刪除 access token 和 refresh token
  //         Cookie accessTokenCookie = setCookie(MyConstants.JWT_COOKIE_NAME, null);
  //         accessTokenCookie.setMaxAge(0);
  //         response.addCookie(accessTokenCookie);
  //         Cookie refreshTokenCookie = setCookie(MyConstants.JWT_REFRESH_COOKIE_NAME, null);
  //         refreshTokenCookie.setMaxAge(0);
  //         response.addCookie(refreshTokenCookie);
  //       }
  //     }
  //   }

  // }

  // 刷新新增令牌至Cookie
  void refreshTokenToCookie(HttpServletResponse response, AuthenticationResponse authenticationResponse) {
    Cookie accessTokenCookie = setCookie(MyConstants.JWT_COOKIE_NAME, authenticationResponse.getAccessToken());
    response.addCookie(accessTokenCookie);
    Cookie refreshTokenCookie = setCookie(MyConstants.JWT_REFRESH_COOKIE_NAME,
        authenticationResponse.getRefreshToken());
    response.addCookie(refreshTokenCookie);
  }

  // 清空雙JWT
  private void removeToken(HttpServletResponse response) {
    Cookie accessTokenCookie = setCookie(MyConstants.JWT_COOKIE_NAME,
        null);
    response.addCookie(accessTokenCookie);
    Cookie refreshTokenCookie = setCookie(MyConstants.JWT_REFRESH_COOKIE_NAME,
        null);
    response.addCookie(refreshTokenCookie);
  }

  // 是否過期
  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  // 拿取過期時間
  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  // 拿取全部內容
  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
