package com.campingmapping.team4.spring.t433forum.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t433forum.model.service.PostService;

@RestController
public class UpdateController {
	
	@Autowired
	private PostService postService;
	
	// 修改
	@PutMapping("/updatepost.controller")
	public String updatePost(@RequestBody Post post) {
		Integer postid = post.getPostid();
		Post postById = postService.getPostById(postid);
		post.setUserprofiles(postById.getUserprofiles());
		post.setUserlike(postById.getUserlike());
		post.setUserunlike(postById.getUserunlike());
		post.setPostreport(postById.getPostreport());
		post.setPosthide(postById.getPosthide());
		postService.update(post);
		String json = "{\"url\" :\"http://localhost:8080/morari/admin/forum/forumadminindex\"}";
		return json;
	}
	
	// 喜歡
	
	// 不喜歡
	
	// 檢舉
	@PutMapping("reportpost.controller")
	public Post reportPost(@RequestBody Post post) {
		return postService.report(post);
	}
	
	// 取消檢舉
	@PutMapping("cancelreportpost.controller")
	public Post cancelReportPost(@RequestBody Post post) {
		return postService.cancelReport(post);
	}
	
	// 隱藏
	@PutMapping("hidepost.controller")
	public Post hidePost(@RequestBody Post post) {
		return postService.hide(post);
	}
	
	// 取消隱藏
	@PutMapping("cancelhidepost.controller")
	public Post cancelHidePost(@RequestBody Post post) {
		return postService.cancelHide(post);
	}
}
