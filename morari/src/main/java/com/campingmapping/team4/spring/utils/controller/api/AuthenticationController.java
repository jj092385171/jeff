package com.campingmapping.team4.spring.utils.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t4_01Member.model.entity.AuthentiaztionResponse;
import com.campingmapping.team4.spring.t4_01Member.model.entity.License;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
import com.campingmapping.team4.spring.t4_01Member.model.entity.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

        @PostMapping("/register")
        public ResponseEntity<AuthentiaztionResponse> regiter(
                        @RequestBody Member member) {

        }

        @PostMapping("/authenticate")
        public ResponseEntity<AuthentiaztionResponse> authenticate(
                        @RequestBody License license) {
        }

}