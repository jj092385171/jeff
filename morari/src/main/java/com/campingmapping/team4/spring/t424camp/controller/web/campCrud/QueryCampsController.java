package com.campingmapping.team4.spring.t424camp.controller.web.campCrud;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.campingmapping.team4.spring.t424camp.model.service.CampService;
import com.campingmapping.team4.spring.t424camp.model.service.CityService;

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

		// 縣市
		if (cityIDs == null || cityIDs.length == 0) {
			errors.put("cityIDs", "必須勾選縣市");
		}

		// 錯誤導回
		if (errors != null && !errors.isEmpty()) {
			return "t4_24camp/admin/QueryPageForm";
		}

		List<Camp> camps = cityService.findCampsByCityIds(cityIDs);

		m.addAttribute("camps", camps);

		return "t4_24camp/admin/QueryByCityIDsResult";
	}

	@PostMapping("/queryCampsByCampID.controller")
	public String queryByID(@RequestParam("campID") String campID, Model m) {

		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		// 縣市
		if (campID == null || campID.length() == 0) {
			errors.put("cityID", "必須勾選縣市");
		}

		// 錯誤導回
		if (errors != null && !errors.isEmpty()) {
			return "redirect:/t4_24camp/admin/QueryPageForm";
		}

		Camp camp = campService.findById(Integer.valueOf(campID));
		m.addAttribute("camp", camp);

		return "t4_24camp/admin/QueryByCampIDResult";
	}

}
