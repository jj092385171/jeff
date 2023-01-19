package com.campingmapping.team4.spring.t433forum.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t433forum.model.service.PostService;

@RestController
public class ShowController {

	@Autowired
	private PostService postService;

	// 查單一貼文
	@GetMapping("/showpostbyid.controller/{postid}")
	public Post processShowPostById(@PathVariable(name = "postid") Integer postId) {
		return postService.getPostById(postId);
	}

	// 查所有貼文
	@GetMapping("/showall.controller")
	public List<Post> processShowAllPost() {
		return postService.getAllPost();
	}
	
	// 查會員貼文
	@GetMapping("/showpostbyuserid.controller/{userid}")
	public List<Post> processShowPostByUserId(@PathVariable(name = "userid") Integer userId){
		return postService.getUserNonHidePost(userId);
	}

	// 查非隱藏貼文
	@GetMapping("/shownonhidepost.controller")
	public List<Post> processShowNonHidePost(){
		
		return postService.getNonHidePost();
	}
	
	// 查隱藏貼文
	@GetMapping("/showhidepost.controller")
	public List<Post> processShowHidePost(){
		return postService.getHidePost();
	}
	
	// 查檢舉貼文
	@GetMapping("/showreportpost.controller")
	public List<Post> processShowReportPost(){
		return postService.getReportPost();
	}
	
}
