package com.campingmapping.team4.spring.t4_01Member.model.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campingmapping.team4.spring.t4_01Member.model.entity.License;



public interface LoginService {

	public License login(String account, String code);
	public HttpSession loginSession(String account, HttpSession session);
	public void loginHistory(String account, String ip);
	public Cookie rember(String rember);
	public int LoginState(HttpServletRequest req, HttpServletResponse resp);

}
