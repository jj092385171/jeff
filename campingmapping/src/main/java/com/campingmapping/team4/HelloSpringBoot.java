package com.campingmapping.team4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {

	@RequestMapping("/")
	public String hello() {
		return "Hello World Spring Boot";
		
	}
	
	
}
