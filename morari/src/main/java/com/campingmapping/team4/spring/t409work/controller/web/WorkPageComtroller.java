package com.campingmapping.team4.spring.t409work.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/work")
public class WorkPageComtroller {

	@GetMapping({ "", "/" })
	public String workIndex() {
		return "work/guest/index";
	}

}