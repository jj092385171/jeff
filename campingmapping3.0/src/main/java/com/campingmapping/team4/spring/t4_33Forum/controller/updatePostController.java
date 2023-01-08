package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

@Controller
public class updatePostController {
	
	@Autowired
	private PostService postService;
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	
	@PostMapping("/updatePost")
	public String updatePost(@RequestParam("postId") String sPostId, @RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("people") String sPeople, @RequestParam("price") String sPrice, @RequestParam("county") String county, 
			@RequestParam("startDate") String sStartDate, @RequestParam("endDate") String sEndDate, @RequestParam("score") String sScore, Model m) {
		
		try {
			Post post = new Post();
			
			System.out.println(sPostId);
			
			int postId = Integer.parseInt(sPostId);
			post.setPostId(postId);
			
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
			
			postService.updatePost(post);
			m.addAttribute("postId", postId);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "redirect:showPostByPostId";
	}
	
	@PostMapping("/reportPost")
	public String reportPost(@RequestParam("postId") int postId, Model m) {
		Boolean reportPost = postService.reportPost(postId);
		m.addAttribute("reportPost", reportPost);
		m.addAttribute("postId", postId);
		return "redirect:showPostByPostId";
	}
	
	@PostMapping("/cancelReportPost")
	public String cancelReportPost(@RequestParam("postId") int postId, Model m) {
		Boolean cancelReportPost = postService.cancelReportPost(postId);
		m.addAttribute("cancelReportPost", cancelReportPost);
		return "redirect:showAllPostAdmin";
	}
	
	@PostMapping("/hidePost")
	public String hidePost(@RequestParam("postId") int postId, Model m) {
		try {
			Boolean hidePost = postService.hidePost(postId);
			m.addAttribute("hidePost", hidePost);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "redirect:showHidePost";
	}
	
	@PostMapping("/cancelHidePost")
	public String cancelHidePost(@RequestParam("postId") int postId, Model m) {
		try {
			Boolean cancelHidePost = postService.cancelHidePost(postId);
			m.addAttribute("hidePost", cancelHidePost);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "redirect:showAllPostAdmin";
	}
}
