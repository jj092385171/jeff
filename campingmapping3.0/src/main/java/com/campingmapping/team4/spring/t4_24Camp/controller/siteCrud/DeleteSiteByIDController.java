package com.campingmapping.team4.spring.t4_24Camp.controller.siteCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_24Camp.model.service.SiteService;

@Controller
public class DeleteSiteByIDController {
	
	@Autowired
	private SiteService siteService;

	@PostMapping("/sitesOfCamp.controller/deleteSiteByID.controller")
	public String deleteSiteByID(@RequestParam("siteID") int siteID, Model m) {
		
		siteService.deletdBySiteID(siteID);
		
		m.addAttribute("ID","siteID: " + Integer.toString(siteID) + " 刪除成功");

		return "/t4_24camp/admin/DeleteByIDSuccess";
	}
	
}
