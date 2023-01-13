package com.campingmapping.team4.spring.t401member.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t433forum.model.dao.repository.PostRepository;
import com.campingmapping.team4.spring.t433forum.model.entity.Post;

import jakarta.transaction.Transactional;

@Controller
public class ProfilesController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;

	@PostMapping("/add")
	@ResponseBody
	@Transactional
	public String add(@RequestParam("account") String account,
			@RequestParam("password") String password) {
		UserProfiles user = UserProfiles.builder().account(account).password(password).build();
		Post post = Post.builder().title("123").userprofiles(user).build();

		userRepository.save(user);
		postRepository.save(post);

		return "message:" + account + "-" + password;
	}

	@GetMapping(path = "/showall")
	@ResponseBody
	public UserProfiles getMemberList() {
		return userRepository.findById(1).get();
	}

	@PostMapping("/profiles.controller")
	@ResponseBody
	public String processAction(@RequestParam("userName") String userName,
			@RequestParam("userAddress") String userAddress,
			@RequestParam("userPhone") String userPhone) {
		return "message:" + userName + "-" + userAddress + "-" + userPhone;
	}

	@PostMapping("/profiles2.controller")
	@ResponseBody
	public String processAction2(@RequestParam("userName") String userName) {
		return "message:" + userName;
	}

}
