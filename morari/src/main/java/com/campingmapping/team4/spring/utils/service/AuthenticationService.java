package com.campingmapping.team4.spring.utils.service;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationRequest;
import com.campingmapping.team4.spring.t401member.model.dto.AuthenticationResponse;
import com.campingmapping.team4.spring.t401member.model.dto.RegisterRequest;
import com.campingmapping.team4.spring.t401member.model.entity.Role;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.utils.config.MyConstants;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;

	// 註冊
	public Boolean register(RegisterRequest request) {
		try {
			UserProfiles userProfiles = UserProfiles.builder()
					.email(request.getEmail())
					.password(passwordEncoder.encode(request.getPassword()))
					.roles(Arrays.asList(Role.USER))
					.build();
			repository.save(userProfiles);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 登入
	public Boolean authenticate(AuthenticationRequest request, HttpServletResponse response) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getEmail(),
							request.getPassword()));
			UserProfiles userProfiles = repository.findByEmail(request.getEmail()).orElseThrow();
			AuthenticationResponse authenticationResponse = jwtService.generateToken(userProfiles,
					request.getRememberMe());
			jwtService.refreshTokenToCookie(response, authenticationResponse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 登入狀態
	public Boolean loginstate(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String cookiejwt = null;
		Boolean islogin = false;
		if (cookies != null) {
			cookiejwt = jwtService.getToken(cookies, MyConstants.JWT_COOKIE_NAME);
		}
		if (cookiejwt == null || cookiejwt.isEmpty()) {
			return false;
		}
		try {
			String userEmail = jwtService.extractUsername(cookiejwt);
			if (userEmail != null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
				islogin = jwtService.isTokenValid(cookiejwt, userDetails);
			}
		} catch (ExpiredJwtException e) {
			islogin = false;
		}
		return islogin;
	}
}
