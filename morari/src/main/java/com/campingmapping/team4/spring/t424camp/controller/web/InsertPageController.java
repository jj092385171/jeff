package com.campingmapping.team4.spring.t424camp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/camp")
public class InsertPageController {

	@GetMapping("/insertPage.controller")
	public String toCampPage() {

		return "camp/admin/InsertCampForm";
	}

	@GetMapping("/insertSitePage.controller")
	public String toSitePage() {

		return "camp/admin/InsertSiteForm";
	}

}
