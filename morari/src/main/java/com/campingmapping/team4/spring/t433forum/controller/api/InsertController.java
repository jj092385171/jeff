package com.campingmapping.team4.spring.t433forum.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t433forum.model.service.PostService;

@RestController
public class InsertController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/insertpost.controller")
	public Post insertPost(@RequestBody Post post) {
		return postService.insert(post);
	}
	
}
