package com.campingmapping.team4.spring.t401member.model.service;

import java.util.List;
import java.util.UUID;

import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailGuestEdit;
import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailguestWeb;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    public List<UesrDetailAdminWeb> showAllUser();

    public String getShot(HttpServletRequest request);

    public String getNickname(HttpServletRequest request);

    public Boolean adminUpdateUser(UesrDetailAdminWeb user);

    public Boolean updateaccountlocked(UUID uid, Boolean accountnonlocked);

    public Boolean updateenabled(UUID uid, Boolean isenabled);

    public UesrDetailguestWeb getUserDetail(UUID uid);

    public UesrDetailGuestEdit getUesrDetailGuestEdit(HttpServletRequest request);
}
