package com.campingmapping.team4.spring.t4_01Member.model.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/thymeleaf")
public class HomeController {
	public static void main(String[] args) {

	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

}