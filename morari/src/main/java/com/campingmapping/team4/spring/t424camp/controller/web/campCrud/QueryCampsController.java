package com.campingmapping.team4.spring.t424camp.controller.web.campCrud;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	
	@PostMapping("/queryCampsByCityIDs.controller")
	@ResponseBody
	public Object queryByCityIDs(@RequestBody@Nullable int[] cityIDs, Model m) {

		HashMap<String, String> errors = new HashMap<String, String>();

		// 縣市
		if (cityIDs == null || cityIDs.length == 0) {
			errors.put("cityIDs", "必須勾選縣市");
		}

		// 錯誤導回
		if (errors != null && !errors.isEmpty()) {
			errors.put("error", "true");
			return errors;
		}
		
		List<Camp> camps = cityService.findCampsByCityIds(cityIDs);
		
		// 空值
		if (camps.size() == 0) {
			errors.put("error", "none");
			errors.put("noData", "查無資料");
			return errors;
		}


		return camps;
	}
	
	@PostMapping("/queryCampByID.controller")
	@ResponseBody
	public Object queryByID(@RequestBody@Nullable Integer campID, Model m) {

		HashMap<String, String> errors = new HashMap<String, String>();

		// 縣市
		if (campID == null) {
			errors.put("campID", "必須輸入ID");
		}

		// 錯誤導回
		if (errors != null && !errors.isEmpty()) {
			errors.put("error", "true");
			return errors;
		}

		Camp camp = campService.findById(campID);
		
		// 空值
		if (camp == null) {
			errors.put("error", "none");
			errors.put("noData", "查無資料");
			return errors;
		}

		return camp;
	}

}
