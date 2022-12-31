package com.campingmapping.team4.spring.t4_11Team.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/team")
public class TeamPageComtroller {

	@GetMapping({ "", "/" })
	public String teamIndex() {
		return "team/index";
	}

}
