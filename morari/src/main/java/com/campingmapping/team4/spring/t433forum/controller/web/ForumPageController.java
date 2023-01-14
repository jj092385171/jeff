package com.campingmapping.team4.spring.t433forum.controller.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t433forum.model.service.PostService;

@Controller
@RequestMapping("/forum")
public class ForumPageController {
	
	private PostService postService;

	@GetMapping({ "", "/" })
	public String forumIndex() {
		return "forum/guest/index";
	}
	
	// 查單一貼文
	@ResponseBody
	@GetMapping("/getpostbyid.controller")
	public Post processGetPostById(Integer id) {
		return postService.getPostById(id); 
	}
	
	// 顯示新增貼文頁面
	@GetMapping("/showInsert.controller")
	public String processShowInsert() {
		return "forum/guest/newpost";
	}
	
	// 顯示所有貼文
	@GetMapping("/showAll.controller")
	public List<Post> processShowAllPost() {
		List<Post> allPost = postService.getAllPost();
		return allPost;
	}

}
