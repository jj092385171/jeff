package com.campingmapping.team4.spring.utils.service;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationRequest;
import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationResponse;
import com.campingmapping.team4.spring.t401member.model.dto.RegisterRequest;
import com.campingmapping.team4.spring.t401member.model.entity.Role;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;
        private final UserDetailsService userDetailsService;

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

        public Boolean loginstate(HttpServletRequest request) {
                Cookie[] cookies = request.getCookies();
                String cookiejwt = null;

                Boolean islogin = false;
                final String JWTCookieName = "sigin";
                final String jwt;
                final String userEmail;

                if (cookies != null) {
                        cookiejwt = Arrays.stream(cookies)
                                        .filter(c -> c.getName().equals(JWTCookieName))
                                        .map(Cookie::getValue)
                                        .findFirst()
                                        .orElse(null);
                }
                if (cookiejwt == null || cookiejwt.isEmpty()) {
                        return false;
                }
                jwt = cookiejwt;
                try {
                        userEmail = jwtService.extractUsername(jwt);
                        if (userEmail != null) {
                                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                                islogin = jwtService.isTokenValid(jwt, userDetails);
                        }
                } catch (ExpiredJwtException e) {
                        islogin = false;
                }
                return islogin;
        }
}
