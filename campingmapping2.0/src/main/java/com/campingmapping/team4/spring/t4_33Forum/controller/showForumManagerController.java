package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

@Controller
public class showForumManagerController {
	@Autowired
	private PostService postService;
	
	@RequestMapping(path = "/showForumManager", method = RequestMethod.POST)
	public String processMainAction(Model m) {
		try {
			List<Post> list = postService.selectAllPost();
			m.addAttribute("postList", list);
			return "/t4_33forum/admin/ForumManagerFirst";
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
