package com.campingmapping.team4.spring.t424camp.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.campingmapping.team4.spring.t424camp.model.entity.Site;
import com.campingmapping.team4.spring.t424camp.model.service.CampService;
import com.campingmapping.team4.spring.t424camp.model.service.SiteService;

@Controller
public class UpdatePageController {

	@Autowired
	private CampService campService;

	@Autowired
	private SiteService siteService;

	@PostMapping("/upadteCampPage1.controller")
	public String upadteCampPage1(@RequestParam("campID") int campID, Model m) {

		Camp camp = campService.findById(campID);

		m.addAttribute("camp", camp);

		return "t4_24camp/admin/UpdateCampByIDForm";
	}

	@PostMapping("/upadteSitePage.controller")
	public String upadteSitePage(@RequestParam("siteID") int siteID, Model m) {

		Site site = siteService.findBySiteId(siteID);

		m.addAttribute("site", site);

		return "t4_24camp/admin/UpdateSiteByIDForm";
	}

}
