package com.campingmapping.team4.spring.t401member.model.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
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
    UserProfilesMapperUesrDetailAdminWebDTO uesrpProfilesMapperUesrDetailAdminWebDTO;
    @Autowired
    UesrDetailAdminWebDTOMapperUserProfiles uesrDetailAdminWebDTOMapperUserProfiles;

    @Override
    @Transactional
    public List<UesrDetailAdminWeb> showAllUser() {

        return userRepository.findAll()
                .stream()
                .map(uesrpProfilesMapperUesrDetailAdminWebDTO)
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
    @Transactional
    public Boolean adminUpdateUser(UesrDetailAdminWeb user) {
        try {
            userRepository.save(uesrDetailAdminWebDTOMapperUserProfiles.apply(user));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Boolean updateaccountlocked(UUID uid, Boolean accountnonlocked) {
        try {
            UserProfiles userProfiles = userRepository.findById(uid).get();
            userProfiles.setAccountnonlocked(accountnonlocked);
            userRepository.save(userProfiles);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateenabled(UUID uid, Boolean isenabled) {
        try {
            UserProfiles userProfiles = userRepository.findById(uid).get();
            userProfiles.setIsenabled(isenabled);
            userRepository.save(userProfiles);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
