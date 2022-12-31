package com.campingmapping.team4.spring.t4_33Forum.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forum")
public class ForumPageComtroller {

	@GetMapping({ "", "/" })
	public String forumIndex() {
		return "forum/index";
	}

}
