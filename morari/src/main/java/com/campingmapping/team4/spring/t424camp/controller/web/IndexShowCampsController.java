package com.campingmapping.team4.spring.t424camp.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.campingmapping.team4.spring.t424camp.model.entity.City;
import com.campingmapping.team4.spring.t424camp.model.entity.Tag;
import com.campingmapping.team4.spring.t424camp.model.service.CampService;
import com.campingmapping.team4.spring.t424camp.model.service.CityService;
import com.campingmapping.team4.spring.t424camp.model.service.TagService;

@RestController
@RequestMapping("/admin/camp")
// @SessionAttributes(names = { "allCamps", "cityList", "tagList" })
public class IndexShowCampsController {

	@Autowired
	private CampService campService;
	@Autowired
	private CityService cityService;
	@Autowired
	private TagService tagService;

	@GetMapping("/indexShowAllCamp.controller")
//	@ResponseBody
	public Map<String, Object> processAction(Model m) {
		List<Camp> allCamps = campService.findAll();
		List<Tag> tagList = tagService.findAll();
		List<City> cityList = cityService.findAll();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allCamps", allCamps);
		map.put("tagList", tagList);
		map.put("cityList", cityList);

		// m.addAttribute("allCamps", allCamps);
		// m.addAttribute("cityList", cityList);
		// m.addAttribute("tagList", tagList);

		return map;
	}

}
