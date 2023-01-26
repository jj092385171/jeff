package com.campingmapping.team4.spring.utils.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.utils.config.MyConstants;

@Service
public class JwtService {

  private static final String SECRET_KEY = "78214125442A462D4A614E645267556B58703273357638792F423F4528482B4B6250655368566D597133743677397A24432646294A404E635166546A576E5A7234753778214125442A472D4B6150645367556B58703273357638792F423F4528482B4D6251655468576D597133743677397A24432646294A404E635266556A586E327234753778214125442A472D4B6150645367566B59703373367638792F423F4528482B4D6251655468576D5A7134743777217A24432646294A404E635266556A586E3272357538782F413F442A472D4B6150645367566B59703373367639792442264529482B4D6251655468576D5A7134743777217A25432A462D4A614E635266556A586E3272357538782F413F4428472B4B6250655367566B5970337336763979244226452948404D635166546A576D5A7134743777217A25432A462D4A614E645267556B58703272357538782F413F4428472B4B6250655368566D5971337436763979244226452948404D635166546A576E5A7234753778217A25432A462D4A614E645267556B58703273357638792F423F4528472B4B6250655368566D597133743677397A24432646294A404D635166546A576E5A7234753778214125442A472D4B6150645267556B58703273357638792F423F4528482B4D6251655468566D597133743677397A24432646294A404E635266556A586E5A723475";

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  // 接收entity準備製作JWT
  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails, false);
  }

  // memberMe
  public String generateToken(UserDetails userDetails, Boolean rememberMe) {
    return generateToken(new HashMap<>(), userDetails, rememberMe);
  }

  // 製作JWT
  public String generateToken(
      Map<String, Object> extraClaims,
      UserDetails userDetails,
      Boolean rememberMe) {
    // 放自定義物件

    UserProfiles userProfile = (UserProfiles) userDetails;
    extraClaims.put("uid", userProfile.getUid());

    return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + (rememberMe ? 1000 * 60 * 60 * 24 * 7 : 1000 * 60 * 24)))
        
        .signWith(getSignInKey(), SignatureAlgorithm.HS512)
        .compact();
  }

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

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

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
