package com.campingmapping.team4.spring.t401member.model.dto;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import com.campingmapping.team4.spring.t401member.model.entity.Role;

public record UesrDetailAdminWeb(
        UUID uid,
        String nickname,
        String firstname,
        String lastname,
        String email,
        String phone,
        Set<Role> roles,
        Date birthday,
        String address,
        Integer gender,
        Long exp,
        Integer leavel,
        Integer point,
        Date registerdata,
        Boolen subscribed,
        String shot,
        String about) {

}