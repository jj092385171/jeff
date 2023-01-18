package com.campingmapping.team4.spring.t424camp.controller.web.campCrud;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.campingmapping.team4.spring.t424camp.model.service.CampService;
import com.campingmapping.team4.spring.t424camp.model.service.CityService;

@Controller
@RequestMapping("/admin/camp")
public class QueryCampsController {

	@Autowired
	private CityService cityService;
	@Autowired
	private CampService campService;

	
	@GetMapping("/QueryByCityIDsResult")
	public String queryByCityIDsResult() {
		return "camp/admin/QueryByCityIDsResult";
	}
	
	@PostMapping("/queryCampsByCityIDs.controller")
	@ResponseBody
	public List<Camp> queryByCityIDs(@RequestBody int[] cityIDs, Model m) {

		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		// 縣市
		if (cityIDs == null || cityIDs.length == 0) {
			errors.put("cityIDs", "必須勾選縣市");
		}

//		// 錯誤導回
//		if (errors != null && !errors.isEmpty()) {
//			return "t4_24camp/admin/QueryPageForm";
//		}

		List<Camp> camps = cityService.findCampsByCityIds(cityIDs);

//		m.addAttribute("camps", camps);

		return camps;
	}

	@GetMapping("/QueryByIDResult")
	public String queryByIDResult() {
		return "camp/admin/QueryByIDResult";
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
