package com.campingmapping.team4.spring.utils.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

	@GetMapping("/home")
	public String index() {
		return "index";
	}
}