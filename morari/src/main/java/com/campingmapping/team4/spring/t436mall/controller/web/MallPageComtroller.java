package com.campingmapping.team4.spring.t436mall.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mall")
public class MallPageComtroller {

	@GetMapping({ "", "/" })
	public String mallIndex() {
		return "mall/guest/index";
	}

}
