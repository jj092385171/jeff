package com.campingmapping.team4.spring.utils.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Text {

	@GetMapping({ "/home", "/" })
	public String home() {
		return "home";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}