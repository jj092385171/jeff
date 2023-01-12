package com.campingmapping.team4.spring.t4_24Camp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.City;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CampService;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CityService;
import com.campingmapping.team4.spring.t4_24Camp.model.service.TagService;

@Controller
@SessionAttributes(names = {"allCamps", "cityList", "tagList"})
public class IndexShowCampsController {
	
	@Autowired
	private CampService campService;
	@Autowired
	private CityService cityService;
	@Autowired
	private TagService tagService;
	
	
	@GetMapping("/indexShowAllCamp.controller")
	public String processAction(Model m) {
		List<Camp> allCamps = campService.showAll();
		List<Tag> tagList = tagService.showAll();
		List<City> cityList = cityService.showAll();
		
		m.addAttribute("allCamps", allCamps);
		m.addAttribute("cityList",cityList);
		m.addAttribute("tagList",tagList);
		
		return "/t4_24camp/admin/CampIndex";
	}

}
