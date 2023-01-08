package com.campingmapping.team4.spring.utils.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t4_01Member.model.dao.repository.MemberRepository;
import com.campingmapping.team4.spring.t4_01Member.model.entity.AuthenticationRequest;
import com.campingmapping.team4.spring.t4_01Member.model.entity.AuthenticationResponse;
import com.campingmapping.team4.spring.t4_01Member.model.entity.License;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
import com.campingmapping.team4.spring.t4_01Member.model.entity.RegisterRequest;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Role;
import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        License license = License.builder().password(passwordEncoder.encode(request.getPassword()))
                .build();
        Member member = Member.builder().account(request.getAccount()).email(request.getEmail()).license(license)
                .role(Role.USER)
                .build();

        repository.save(member);

        String jwtToken = jwtService.generateToken(member);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getAccount(),
                        request.getPassword()));
        Member member = repository.findByAccount(request.getAccount())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(member);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}