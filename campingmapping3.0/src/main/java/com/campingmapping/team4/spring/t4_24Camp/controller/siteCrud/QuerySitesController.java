package com.campingmapping.team4.spring.t4_24Camp.controller.siteCrud;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;
import com.campingmapping.team4.spring.t4_24Camp.model.service.SiteService;

@Controller
public class QuerySitesController {
	
	@Autowired
	private SiteService siteService;
	
	@GetMapping("/sitesOfCamp.controller/{campID}")
	public String queryByCamp(@PathVariable("campID") int campID, Model m) {
		System.out.println("campID: " + campID);
		Set<Site> sites = siteService.findSitesByCampID(campID);
		m.addAttribute("sites", sites);
		
		return "/t4_24camp/admin/SitesOfCamp";
	}

}
