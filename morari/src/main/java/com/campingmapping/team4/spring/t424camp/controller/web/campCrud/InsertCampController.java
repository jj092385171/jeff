package com.campingmapping.team4.spring.t424camp.controller.web.campCrud;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.campingmapping.team4.spring.t424camp.model.service.CampService;

@Controller
@RequestMapping("/admin/camp")
public class InsertCampController {

	@Autowired
	private CampService campService;

	@PostMapping("/insertCamp.controller")
	@ResponseBody
	public Camp insertCamp(@RequestParam("campName") @Nullable String campName,
			@RequestParam("campPicturesPath") @Nullable MultipartFile mf,
			@RequestParam("cityID") @Nullable String cityID, @RequestParam("location") @Nullable String location,
			@RequestParam("tagID") @Nullable int[] tagIDs, @RequestParam("description") @Nullable String description,
			Model m) throws IllegalStateException, IOException {

		// 存錯誤的map
		Map<String, String> errors = new HashMap<>();

		// 營地名
		if (campName == null || campName.trim().length() == 0) {
			errors.put("campName", "必須輸入營地名稱");
		}

		// 圖
		if (mf.isEmpty()) {
			errors.put("campPicturesPath", "必須選擇圖片");
		}
		String saveFileDir = "C:/gitapp/EEIT56_Team4/campingmapping3.0/src/main/webapp/WEB-INF/resources/images/";
		String fileName = mf.getOriginalFilename();
		File saveFilePath = new File(saveFileDir, fileName);
		mf.transferTo(saveFilePath);
//		saveFilePath.delete();

		// 縣市
		if (cityID == null || cityID.length() == 0) {
			errors.put("cityID", "必須輸入縣市");
		}

		// 地址
		if (location == null || location.trim().length() == 0) {
			errors.put("location", "必須輸入地址");
		}

		// 標籤
		if (tagIDs == null || tagIDs.length == 0) {
			errors.put("tagIDs", "必須選擇標籤");
		}

//		// 錯誤導回
//		if (errors != null && !errors.isEmpty()) {
//			m.addAttribute("errors", errors);
//
//			return "t4_24camp/admin/InsertCampForm";
//		}

		Camp camp = campService.insert(campName, Integer.valueOf(cityID), location, fileName, description, tagIDs);

//		m.addAttribute("camp", camp);
//		m.addAttribute("what", "新增");

		return camp;
	}

}
