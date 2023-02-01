package com.campingmapping.team4.spring.t433forum.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t433forum.model.entity.PostComment;
import com.campingmapping.team4.spring.t433forum.model.service.PostCommentService;
import com.campingmapping.team4.spring.t433forum.model.service.PostService;

@RestController
public class InsertPostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private PostCommentService postCommentService;
	
	@PostMapping("/insertpost.controller")
	public String insertPost(@RequestBody Post post) {
		postService.insert(post);
		return "true";
	}
	
	@PostMapping("/insertpostcomment.controller/{postid}")
	public String insertPostComment(@RequestBody PostComment postComment, @PathVariable Integer postid) {
		Post post = postService.getPostById(postid);
		// Post post = new Post();
		postComment.setPost(post);
		postCommentService.insert(postComment);
		
		return "true";
	}
}
