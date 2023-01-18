package com.campingmapping.team4.spring.t424camp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/camp")
public class InsertPageController {

	@GetMapping("/insertPage.controller")
	public String toCampPage() {

		return "camp/admin/InsertCampForm";
	}

	@PostMapping("/insertSitePage.controller")
	public String toSitePage(@RequestParam("campID") int campID, Model m) {
		m.addAttribute("campID", campID);

		return "camp/admin/InsertSiteForm";
	}

}
