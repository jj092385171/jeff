package com.campingmapping.team4.spring.t4_01Member.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfilesController {

	@PostMapping("/profiles.controller")
	@ResponseBody
	public String processAction(@RequestParam("userName") String userName,
			@RequestParam("userAddress") String userAddress,
			@RequestParam("userPhone") String userPhone) {
		System.out.println("in");
		return "message:" + userName + "-" + userAddress + "-" + userPhone;
	}

}
