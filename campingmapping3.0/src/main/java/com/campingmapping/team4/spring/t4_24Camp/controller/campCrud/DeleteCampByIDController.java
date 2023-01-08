package com.campingmapping.team4.spring.t4_24Camp.controller.campCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_24Camp.model.service.CampService;

@Controller
public class DeleteCampByIDController {
	
	@Autowired
	private CampService campService;
	
	
	@PostMapping("deleteCampByID.controller")
	public String deleteCampByID(@RequestParam("campID") int campID, Model m) {
		
		campService.deletdByCampID(campID);
		m.addAttribute("ID","campID: " + campID + " 刪除成功");
		
		return "/t4_24camp/admin/CampIndex";
	}
	
	

}
