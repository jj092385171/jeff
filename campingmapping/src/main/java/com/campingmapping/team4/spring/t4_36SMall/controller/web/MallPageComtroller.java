package com.campingmapping.team4.spring.t4_36SMall.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mall")
public class MallPageComtroller {

	@GetMapping({ "", "/" })
	public String getMemberList() {
		return "mall/index";
	}

}
