package com.campingmapping.team4.spring.t424camp.controller.web.siteCrud;

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

import com.campingmapping.team4.spring.t424camp.model.entity.Site;
import com.campingmapping.team4.spring.t424camp.model.service.SiteService;

@Controller
@RequestMapping("/admin/camp")
public class UpdateSiteByIDController {

	@Autowired
	private SiteService siteService;

	@PostMapping("/updateSiteByID.controller")
	@ResponseBody
	public Site updateSiteByID(@RequestParam("siteID") Integer siteID,
			@RequestParam("siteName") @Nullable String siteName,
			@RequestParam("sitePicturesPath") @Nullable MultipartFile mf,
			@RequestParam("totalSites") @Nullable Integer totalSites,
			@RequestParam("siteMoney") @Nullable Integer siteMoney, @RequestParam("campID") Integer campID, Model m)
			throws IllegalStateException, IOException {

		// 存錯誤的map
		Map<String, String> errors = new HashMap<>();
		m.addAttribute("errors", errors);

		// 營區位名
		if (siteName == null || siteName.trim().length() == 0) {
			errors.put("siteName", "必須輸入營區位名稱");
		}

		// 圖
		if (mf.isEmpty()) {
			errors.put("sitePicturesPath", "必須選擇圖片");
		}
		String saveFileDir = "C:/gitapp/EEIT56_Team4/campingmapping3.0/src/main/webapp/WEB-INF/resources/images/";
		String fileName = mf.getOriginalFilename();
		File saveFilePath = new File(saveFileDir, fileName);
		mf.transferTo(saveFilePath);

		// 總營位數
		if (totalSites == null ) {
			errors.put("totalSites", "必須輸入總營位數");
		}

		// 營位金額
		if (siteMoney == null ) {
			errors.put("siteMoney", "必須輸入營位金額");
		}

//		// 錯誤導回
//		if (errors != null && !errors.isEmpty()) {
//			m.addAttribute("campID", campID);
//			m.addAttribute("errors", errors);
//
//			return "t4_24camp/admin/UpdateSiteByIDForm";
//		}

		Site site = siteService.update(siteID, siteName, fileName, totalSites, siteMoney, campID);

//		m.addAttribute("site", site);
//		m.addAttribute("what", "更新");

		return site;
	}

}
