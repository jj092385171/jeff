package com.campingmapping.team4.spring.utils.service;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationRequest;
import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationResponse;
import com.campingmapping.team4.spring.t401member.model.dto.RegisterRequest;
import com.campingmapping.team4.spring.t401member.model.entity.Role;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
                UserProfiles userProfiles = UserProfiles.builder()
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .roles(Arrays.asList(Role.USER))
                                .build();
                repository.save(userProfiles);
                String jwtToken = jwtService.generateToken(userProfiles);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));
                var userProfiles = repository.findByEmail(request.getEmail())
                                .orElseThrow();
                String jwtToken = jwtService.generateToken(userProfiles, request.getRememberMe());
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }
        public boolean loginstate(AuthenticationRequest request){
                Cookie[] cookies = request.getCookies();
    String cookiejwt = null;
    if (cookies != null) {
      cookiejwt = Arrays.stream(cookies)
          .filter(c -> c.getName().equals(JWTCookieName))
          .map(Cookie::getValue)
          .findFirst()
          .orElse(null);
    }
    if (cookiejwt == null || cookiejwt.isEmpty()) {
      filterChain.doFilter(request, response);
      return;
    }
    jwt = cookiejwt;

    try {
      userEmail = jwtService.extractUsername(jwt);

      if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
        if (jwtService.isTokenValid(jwt, userDetails)) {
          UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
              userDetails,
              null,
              userDetails.getAuthorities());
          authToken.setDetails(
              new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authToken);
        }
      }
      Cookie jwtCookie = new Cookie(JWTCookieName, cookiejwt);
      jwtCookie.setHttpOnly(true);
      jwtCookie.setSecure(true);
      jwtCookie.setPath("/");
      response.addCookie(jwtCookie);
      filterChain.doFilter(request, response);
    } catch (ExpiredJwtException e) {
      // 刪除 JWT cookie
      e.printStackTrace();
      Cookie jwtCookie = new Cookie(JWTCookieName, null);
      jwtCookie.setMaxAge(1000 * 60 * 24);
      jwtCookie.setHttpOnly(true);
      jwtCookie.setSecure(true);
      jwtCookie.setPath("/");
      response.addCookie(jwtCookie);
      response.sendRedirect("/morari/home");
    }
  

        }
}
