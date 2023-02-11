package com.campingmapping.team4.spring.t401member.model.service;

import java.util.List;

import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    public List<UesrDetailAdminWeb> showAllUser();

    public String getShot(HttpServletRequest request);

    public String getNickname(HttpServletRequest request);

    public Boolean adminUpdateUser(UesrDetailAdminWeb user);
}
