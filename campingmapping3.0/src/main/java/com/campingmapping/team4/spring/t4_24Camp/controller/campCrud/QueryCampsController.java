package com.campingmapping.team4.spring.t4_24Camp.controller.campCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CampService;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CityService;


@Controller
public class QueryCampsController {
	
	@Autowired
	private CityService cityService;
	@Autowired
	private CampService campService;
	
	@PostMapping("/queryCampsByCityIDs.controller")
	public String queryByCityIDs(@RequestParam("cityID") int[] cityIDs, Model m) {
		
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		//縣市
		if (cityIDs == null || cityIDs.length == 0) {
			errors.put("cityIDs", "必須勾選縣市");
		}
		
		//錯誤導回
		if(errors != null && !errors.isEmpty()) {
			return "/t4_24camp/admin/QueryPageForm";
		}
		
		List<Camp> camps = new ArrayList<Camp>();
		for(int cityID : cityIDs) {
			camps.addAll(cityService.findCampsByCityID(cityID));
		}
		
		m.addAttribute("camps", camps);
		
		return "/t4_24camp/admin/QueryByCityIDsResult";
	}
	
	@PostMapping("/queryCampsByCampIDs.controller")
	public String queryByID(@RequestParam("campID") String campID, Model m) {
		
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		//縣市
		if (campID == null || campID.length() == 0) {
			errors.put("cityID", "必須勾選縣市");
		}
		
		//錯誤導回
		if(errors != null && !errors.isEmpty()) {
			return "redirect:/t4_24camp/admin/QueryPageForm";
		}
		
		Camp camp = campService.findCampByID(Integer.valueOf(campID));
		m.addAttribute("camp", camp);
		
		return "/t4_24camp/admin/QueryByCampIDResult";
	}

}
