package com.campingmapping.team4.spring.t401member.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;
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

        });
        return list;
    }

}
