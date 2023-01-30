package com.campingmapping.team4.spring.t424camp.controller.web.siteCrud;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t424camp.model.entity.Site;
import com.campingmapping.team4.spring.t424camp.model.service.SiteService;

@Controller
@RequestMapping("/admin/camp")
public class QuerySitesController {

	@Autowired
	private SiteService siteService;

	
	@GetMapping("/SitesOfCamp")
	public String queryByCityIDsResult() {
		return "camp/admin/SitesOfCamp" ;
	}
	
	
	@GetMapping("/sitesOfCamp.controller/{campID}")
	@ResponseBody
	public Set<Site> queryByCamp(@PathVariable("campID") int campID, Model m) {

		return siteService.findSiteByCampId(campID);
	}

}

