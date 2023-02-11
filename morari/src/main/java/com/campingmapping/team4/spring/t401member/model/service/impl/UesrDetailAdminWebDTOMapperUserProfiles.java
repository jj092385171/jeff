package com.campingmapping.team4.spring.t401member.model.service.impl;

import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.entity.UserDetail;
import com.campingmapping.team4.spring.t401member.model.entity.UserName;
import com.campingmapping.team4.spring.t401member.model.entity.UserPrivacy;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;

@Service
public class UesrDetailAdminWebDTOMapperUserProfiles implements Function<UesrDetailAdminWeb, UserProfiles> {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public UserProfiles apply(UesrDetailAdminWeb uesrDetailAdminWeb) {
        UserProfiles userProfiles = userRepository.findById(UUID.fromString(uesrDetailAdminWeb.uid())).get();
        UserDetail userdetail = userProfiles.getUserdetail();
        UserName usernames = userProfiles.getUsernames();
        UserPrivacy userprivacy = userProfiles.getUserprivacy();
        usernames.setLastname(uesrDetailAdminWeb.lastname());
        usernames.setFirstname(uesrDetailAdminWeb.firstname());
        userprivacy.setPhone(uesrDetailAdminWeb.phone());
        userprivacy.setBirthday(uesrDetailAdminWeb.birthday());
        userprivacy.setAddress(uesrDetailAdminWeb.address());
        userdetail.setNickname(uesrDetailAdminWeb.nickname());
        userdetail.setExp(uesrDetailAdminWeb.exp());
        userdetail.setLevel(uesrDetailAdminWeb.level());
        userdetail.setPoint(uesrDetailAdminWeb.point());
        userdetail.setGender(uesrDetailAdminWeb.gender());
        userdetail.setSubscribed(uesrDetailAdminWeb.subscribed());
        userdetail.setShot(uesrDetailAdminWeb.shot());
        userdetail.setAbout(uesrDetailAdminWeb.about());
        userProfiles.setRoles(uesrDetailAdminWeb.roles());
        userProfiles.setUserdetail(userdetail);
        userProfiles.setUsernames(usernames);
        userProfiles.setUserprivacy(userprivacy);
        userProfiles.setAccountnonlocked(uesrDetailAdminWeb.accountnonlocked());
        userProfiles.setIsenabled(uesrDetailAdminWeb.isenabled());
        return userProfiles;
    }

}