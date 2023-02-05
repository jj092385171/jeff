package com.campingmapping.team4.spring.t401member.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.entity.UserDetail;
import com.campingmapping.team4.spring.t401member.model.entity.UserPrivacy;
import com.campingmapping.team4.spring.t401member.model.entity.UserName;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t401member.model.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UesrDetailAdminWeb> showAllUser() {

        List<UesrDetailAdminWeb> list = new ArrayList<UesrDetailAdminWeb>();
        List<UserProfiles> users = userRepository.findAll();
        users.forEach(u -> {
            UserName n = u.getUsernames();
            UserDetail d = u.getUserdetail();
            UserPrivacy p = u.getUserprivacy();
            UesrDetailAdminWeb udw = new UesrDetailAdminWeb(
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
            list.add(udw);
        });
        return list;
    }

}
