package com.campingmapping.team4.spring.t401member.model.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.service.UserService;
import com.campingmapping.team4.spring.utils.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    UesrDetailAdminWebDTOMapper udamapper;

    @Override
    @Transactional
    public List<UesrDetailAdminWeb> showAllUser() {

        return userRepository.findAll()
        .stream()
        .map(udamapper)
        .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public String getShot(HttpServletRequest request) {
        UUID uid = jwtService.getUId(request);
        return userRepository.findById(uid).get().getUserdetail().getShot();
    }

    @Override
    @Transactional
    public String getNickname(HttpServletRequest request) {
        UUID uid = jwtService.getUId(request);
        return userRepository.findById(uid).get().getUserdetail().getNickname();
    }

    @Override
    public void adminUpdateUser(UesrDetailAdminWeb user) {

    }

}
