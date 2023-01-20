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
                                .account(request.getAccount())
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
                                                request.getAccount(),
                                                request.getPassword()));
                var userProfiles = repository.findByAccount(request.getAccount())
                                .orElseThrow();
                var jwtToken = jwtService.generateToken(userProfiles);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }
}
