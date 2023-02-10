package com.campingmapping.team4.spring.t401member.model.service.impl;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.entity.UserDetail;
import com.campingmapping.team4.spring.t401member.model.entity.UserName;
import com.campingmapping.team4.spring.t401member.model.entity.UserPrivacy;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;

@Service
public class UesrDetailAdminWebDTOMapper implements Function<UserProfiles, UesrDetailAdminWeb> {

    @Override
    public UesrDetailAdminWeb apply(UserProfiles u) {
        UserName n = u.getUsernames();
        UserDetail d = u.getUserdetail();
        UserPrivacy p = u.getUserprivacy();
        return new UesrDetailAdminWeb(
                u.getUid().toString(),
                d.getNickname(),
                n.getFirstname(),
                n.getLastname(),
                u.getEmail(),
                p.getPhone(),
                u.getRoles(),
                p.getBirthday(),
                p.getAddress(),
                d.getGender(),
                d.getExp(),
                d.getLevel(),
                d.getPoint(),
                d.getRegisterdata(),
                d.getSubscribed(),
                d.getShot(),
                d.getAbout());

    }

}