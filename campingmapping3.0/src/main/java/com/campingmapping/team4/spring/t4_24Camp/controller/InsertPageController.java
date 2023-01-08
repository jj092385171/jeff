package com.campingmapping.team4.spring.t4_24Camp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InsertPageController {
	
	@GetMapping("/insertPage.controller")
	public String toCampPage() {
		return "/t4_24camp/admin/InsertCampForm";
	}

	@PostMapping("insertSitePage.controller")
	public String toSitePage(@RequestParam("campID") int campID, Model m) {
		m.addAttribute("campID", campID);
		
		return "/t4_24camp/admin/InsertSiteForm";
	}
	
}
