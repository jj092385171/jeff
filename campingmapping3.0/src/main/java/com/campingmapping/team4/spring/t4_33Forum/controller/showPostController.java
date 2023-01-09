package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostCommentService;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

@Controller
public class showPostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private PostCommentService postCommentService;
	
	@GetMapping("/showAllPost")
	public String showAllPost(Model m) {
		List<Post> findAllPost = postService.findAllPost();
		m.addAttribute("postList", findAllPost);
		return "/t4_33forum/guest/showAllPost";
	}
	
	@GetMapping("/showAllPostAdmin")
	public String showAllPostAdmin(Model m) {
		List<Post> findAllPost = postService.findAllPost();
		m.addAttribute("postList", findAllPost);
		return "/t4_33forum/admin/showAllPostAdmin";
	}
	
	@GetMapping("/showPostByPostId")
	public String showPostByPostId(@RequestParam("postId") int postId, Model m) {
		Post findPostByPostId = postService.findPostByPostId(postId);
		List<PostComment> findPostCommentByPostId = postCommentService.findPostCommentByPostId(postId);
		m.addAttribute("resultPost", findPostByPostId);
		m.addAttribute("resultpostComment", findPostCommentByPostId);
		return "/t4_33forum/guest/showPostByPostId";
	}
	
	@GetMapping("/showUpdatePostByPostId")
	public String showUpdatePostByPostId(@RequestParam("postId") int postId, Model m) {
		Post findPostByPostId = postService.findPostByPostId(postId);
		m.addAttribute("resultPost", findPostByPostId);
		return "/t4_33forum/guest/updatePost";
	}
	
	// 之後應該要用user判斷
	@GetMapping("/showUpdatePostByPostIdAdmin")
	public String showUpdatePostByPostIdAdmin(@RequestParam("postId") int postId, Model m) {
		Post findPostByPostId = postService.findPostByPostId(postId);
		m.addAttribute("resultPost", findPostByPostId);
		return "/t4_33forum/admin/updatePostAdmin";
	}
	
	@GetMapping("/showPostByUserId")
	public String showPostByUserId(/*@RequestParam("userId") int userId,*/ Model m) {
		int userId = 9;
		List<Post> findPostByUserId = postService.findPostByUserId(userId);
		m.addAttribute("postList", findPostByUserId);
		return "/t4_33forum/guest/showPostByUserId";
	}
	
	@GetMapping("/showReportPost")
	public String showReportPost(Model m) {
		List<Post> findReportPost = postService.findReportPost();
		m.addAttribute("postReportList", findReportPost);
		return "/t4_33forum/admin/showReportPost";
	}
	
	@GetMapping("/showHidePost")
	public String showHidePost(Model m) {
		List<Post> findHidePost = postService.findHidePost();
		m.addAttribute("postHideList", findHidePost);
		return "/t4_33forum/admin/showHidePost";
	}
	
}
