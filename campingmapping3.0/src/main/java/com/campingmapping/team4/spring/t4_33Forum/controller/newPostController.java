package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostCommentService;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

@Controller
public class newPostController {
	@Autowired
	private PostService postService;
	@Autowired
	private PostCommentService postCommentService;
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	
	@GetMapping("/newPost")
	public String newPost() {
		return "/t4_33forum/guest/newPost";
	}
	
	@PostMapping("/insertPost")
	public String insertPost(@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("people") String sPeople, @RequestParam("price") String sPrice, @RequestParam("county") String county, 
			@RequestParam("startDate") String sStartDate, @RequestParam("endDate") String sEndDate, @RequestParam("score") String sScore, Model m) {
		
		try {
			Post post = new Post();
			post.setTitle(title);
			post.setContent(content);
			
			int people = 0;
			if(sPeople != "") {
				people = Integer.parseInt(sPeople);
			}
			post.setPeople(people);
			
			int price = 0;
			if(sPrice != "") {
				price = Integer.parseInt(sPrice);
			}
			post.setPrice(price);
			
			post.setCounty(county);
			
			Date startDate = null;
			if(sStartDate != "") {
				startDate = date.parse(sStartDate);
			}
			post.setStartDate(startDate);
			
			Date endDate = null;
			if(sEndDate != "") {
				endDate = date.parse(sEndDate);
			}
			post.setEndDate(endDate);
			
			int score = 0;
			if(sScore != "") {
				score = Integer.parseInt(sScore);
			}
			post.setScore(score);
			
			postService.insertPost(post);
			
//			m.addAttribute("userId", userId);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "redirect:showPostByUserId";
	}
	
	@PostMapping("/insertPostComment")
	public String insertPostComment(@RequestParam("postId") String sPostId, @RequestParam("comment") String comment, Model m) {
		
		PostComment postComment = new PostComment();
		int postId = Integer.parseInt(sPostId);
		Post post = new Post();
		post.setPostId(postId);
		postComment.setPost(post);
		postComment.setPostComment(comment);
		postCommentService.insertPostComment(postComment);
		m.addAttribute("postId", postId);
		return "redirect:showPostByPostId";
	}
}
