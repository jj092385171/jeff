package com.campingmapping.team4.spring.utils.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t4_01Member.model.entity.AuthenticationRequest;
import com.campingmapping.team4.spring.t4_01Member.model.entity.AuthenticationResponse;
import com.campingmapping.team4.spring.t4_01Member.model.entity.RegisterRequest;
import com.campingmapping.team4.spring.utils.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

        private final AuthenticationService service;

        @PostMapping("/register")
        public ResponseEntity<AuthenticationResponse> register(
                        @RequestBody RegisterRequest request) {
                return ResponseEntity.ok(service.register(request));
        }

        @PostMapping("/authenticate")
        public ResponseEntity<AuthenticationResponse> authenticate(
                        @RequestBody AuthenticationRequest request) {
                return ResponseEntity.ok(service.authenticate(request));
        }

}