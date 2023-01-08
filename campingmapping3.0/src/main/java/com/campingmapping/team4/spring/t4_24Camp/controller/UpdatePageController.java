package com.campingmapping.team4.spring.t4_24Camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CampService;
import com.campingmapping.team4.spring.t4_24Camp.model.service.SiteService;

@Controller
public class UpdatePageController {

	@Autowired
	private CampService campService;
	
	@Autowired
	private SiteService siteService;
	

	@PostMapping("upadteCampPage.controller")
	public String upadteCampPage(@RequestParam("campID") int campID,Model m) {

		Camp camp = campService.findCampByID(campID);
		
		m.addAttribute("camp", camp);

		return "/t4_24camp/admin/UpdateCampByIDForm";
	}

	@PostMapping("sitesOfCamp.controller/upadteSitePage.controller")
	public String upadteSitePage(@RequestParam("siteID") int siteID,Model m) {
		
		Site site = siteService.findSiteByID(siteID);
		
		m.addAttribute("site", site);
		
		return "/t4_24camp/admin/UpdateSiteByIDForm";
	}
	
}
