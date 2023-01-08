package com.campingmapping.team4.spring.t4_24Camp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CampService;

@Controller
public class UpdateCampPageController {

	@Autowired
	private CampService campService;
	

	@PostMapping("upadteCampPage.controller")
	public String upadteCampPage(@RequestParam("campID") int campID,Model m) {

		Camp camp = campService.findCampByID(campID);
		
		m.addAttribute("camp", camp);

		return "/t4_24camp/admin/UpdateCampByIDForm";
	}

}
