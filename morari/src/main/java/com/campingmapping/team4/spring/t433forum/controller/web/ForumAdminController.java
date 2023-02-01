package com.campingmapping.team4.spring.t433forum.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/forum")
public class ForumAdminController {
	
	@GetMapping("/forumadminindex")
    public String index() {
        return "forum/admin/admin";
    }

	// 顯示新增貼文頁面
	@GetMapping("/showinsertadmin.controller")
	public String processShowInsert() {
		return "forum/admin/newpost";
	}
	
	// 顯示修改貼文
	@GetMapping("/showupdateadmin.controller/*")
	public String processShowUpdate() {
		return "forum/admin/updatepost";
	}
}
