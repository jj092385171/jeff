package com.campingmapping.team4.spring.t401member.model.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.UserDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.dto.UserDetailGuestEdit;
import com.campingmapping.team4.spring.t401member.model.dto.UserDetailGuestWeb;
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
    UserProfilesMapperUesrDetailAdminWebDTO userpProfilesMapperUesrDetailAdminWebDTO;
    @Autowired
    UserDetailAdminWebDTOMapperUserProfiles userDetailAdminWebDTOMapperUserProfiles;
    @Autowired
    UserProfilesMapperUesrDetailGuestWebDTO userProfilesMapperUesrDetailguestWebDTO;
    @Autowired
    UserProfilesMapperUesrDetailGuestEditDTO userProfilesMapperUesrDetailGuestEditDTO;
    @Autowired
    UserDetailGuestEditDTOMapperUserProfiles userDetailGuestEditDTOMapperUserProfiles;

    @Override
    @Transactional
    public List<UserDetailAdminWeb> showAllUser() {

        return userRepository.findAll()
                .stream()
                .map(userpProfilesMapperUesrDetailAdminWebDTO)
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
    public Boolean adminUpdateUser(UserDetailAdminWeb user) {
        try {
            userRepository.save(userDetailAdminWebDTOMapperUserProfiles.apply(user));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    @Transactional
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
    @Transactional
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

    @Override
    @Transactional
    public UserDetailGuestWeb getUserDetail(UUID uid) {
        return userProfilesMapperUesrDetailguestWebDTO.apply(userRepository.findById(uid).get());
    }

    @Override
    @Transactional
    public UserDetailGuestEdit getUesrDetailGuestEdit(HttpServletRequest request) {
        UUID uid = jwtService.getUId(request);
        UserProfiles userProfiles = userRepository.findById(uid).get();
        UserDetailGuestEdit uesrDetailGuestEdit = userProfilesMapperUesrDetailGuestEditDTO.apply(userProfiles);
        return uesrDetailGuestEdit;
    }

    @Override
    @Transactional
    public Boolean guestUpdateUser(UserDetailGuestEdit user) {
        try {
            userRepository.save(userDetailGuestEditDTOMapperUserProfiles.apply(user));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
