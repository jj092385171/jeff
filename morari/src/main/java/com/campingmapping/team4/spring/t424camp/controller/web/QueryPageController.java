package com.campingmapping.team4.spring.t424camp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QueryPageController {

	@GetMapping("/queryPage.controller")
	public String toPage() {
		return "t4_24camp/admin/QueryPageForm";
	}

}
