package com.campingmapping.team4.spring.utils.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class wellcomeController {
	@GetMapping("/")
	public String index() {
		return "wellcome";
	}

}
