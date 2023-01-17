package com.campingmapping.team4.spring.t433forum.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forum")
public class ForumPageController {
	
	@GetMapping({ "", "/" })
	public String forumIndex() {
		return "forum/guest/index";
	}

	// 顯示新增貼文頁面
	@GetMapping("/showInsert.controller")
	public String processShowInsert() {
		return "forum/guest/newpost";
	}

}
