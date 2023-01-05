package com.campingmapping.team4.spring.t4_24Camp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InsertPageController {
	
	@GetMapping("/insertPage.controller")
	public String toPage() {
		return "/t4_24camp/admin/InsertCampForm";
	}

}
