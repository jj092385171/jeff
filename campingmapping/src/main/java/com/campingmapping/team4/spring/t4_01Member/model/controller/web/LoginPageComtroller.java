package com.campingmapping.team4.spring.t4_01Member.model.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageComtroller {

	@GetMapping({ "/login", "/login/" })
	public String login() {
		return "camper/login";
	}

	@GetMapping({ "/register", "/register/" })
	public String register() {
		return "camper/register";
	}

	@GetMapping({ "/forgotpassword", "/forgotpassword/" })
	public String forgotPassword() {
		return "camper/forgotpassword";
	}

}
