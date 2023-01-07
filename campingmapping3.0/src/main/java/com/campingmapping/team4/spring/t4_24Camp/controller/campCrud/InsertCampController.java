package com.campingmapping.team4.spring.t4_24Camp.controller.campCrud;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.City;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CampService;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CityService;
import com.campingmapping.team4.spring.t4_24Camp.model.service.TagService;

@Controller
public class InsertCampController {
	
	@Autowired
	private CampService campService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private TagService tagService;
	
	
	@PostMapping("insertCamp.controller")
	public String insertCamp(@RequestParam("campName") String campName, @RequestParam("campPictures") MultipartFile mf, @RequestParam("cityID") String cityID, @RequestParam("location") String location, @RequestParam("tagID") int[] tagIDs, @RequestParam("description") String description, Model m) throws IllegalStateException, IOException{
		
		Map<String, String> errors = new HashMap<>();
		m.addAttribute("errors",errors);
		
		// 營地名
		if (campName == null || campName.trim().length() == 0) {
			errors.put("campName", "必須輸入營地名稱");
		}
		
		// 圖
		if (mf.isEmpty()) {
			errors.put("campPictures", "必須選擇圖片");
		}
		String saveFileDir = "C:/gitapp/EEIT56_Team4/campingmapping3.0/src/main/webapp/WEB-INF/resources/images/";
		String fileName = mf.getOriginalFilename();
		File saveFilePath = new File(saveFileDir, fileName);
		mf.transferTo(saveFilePath);
		
		// 縣市
		if (cityID == null || cityID.length() == 0) {
			errors.put("cityID", "必須輸入縣市");
		}
		City city = cityService.findCityByID(Integer.valueOf(cityID) );
		
		// 地址
		if (location == null || location.trim().length() == 0) {
			errors.put("location", "必須輸入地址");
		}
		
		//標籤
		if (tagIDs == null || tagIDs.length == 0) {
			errors.put("tagIDs", "必須選擇標籤");
		}
		Set<Tag> tagSet = new HashSet<Tag>();
		for (int tagID : tagIDs) {
			Tag tag = tagService.findByID(tagID);
			System.out.println(tag.getTagName());
			tagSet.add(tag);
		}
		//錯誤導回
		if(errors != null && !errors.isEmpty()) {
			return "redirect:/t4_24camp/admin/QueryPageForm";
		}
		
		Camp cb = new Camp();
		
		cb.setCampName(campName);
		cb.setCity(city);
		cb.setLocation(location);
		cb.setCampPicturesPath(fileName);
		cb.setDescription(description);
		cb.setTags(tagSet);
		
		Integer campID = campService.AddCamp(cb);
		Camp resultCamp = campService.findCampByID(campID);
		
		m.addAttribute("campID", resultCamp.getCampID());
		m.addAttribute("campName", resultCamp.getCampName());
		m.addAttribute("", resultCamp.getCampPicturesPath());
		m.addAttribute("city", resultCamp.getCity());
		m.addAttribute("location", resultCamp.getLocation());
		m.addAttribute("tags", resultCamp.getTags());
		m.addAttribute("what", "新增");
		
		return "/t4_24camp/admin/InsertUpdateCampSuccess";
	}

}
