package com.campingmapping.team4.spring.t4_24Camp.controller.siteCrud;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CampService;
import com.campingmapping.team4.spring.t4_24Camp.model.service.SiteService;

@Controller
public class UpdateSiteByIDController {
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private CampService campService;
		
		
	@PostMapping("/sitesOfCamp.controller/updateSiteByID.controller")
	public String updateSiteByID(@RequestParam("siteID") Integer siteID, @RequestParam("siteName")@Nullable String siteName, @RequestParam("sitePicturesPath")@Nullable MultipartFile mf,@RequestParam("totalSites")@Nullable String totalSites, @RequestParam("siteMoney")@Nullable String siteMoney, @RequestParam("campID") Integer campID, Model m) throws IllegalStateException, IOException {
		
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
		if (totalSites == null || totalSites.length() == 0) {
			errors.put("totalSites", "必須輸入總營位數");
		}

		// 營位金額
		if (siteMoney == null || siteMoney.trim().length() == 0) {
			errors.put("siteMoney", "必須輸入營位金額");
		}
		
		
		// 錯誤導回
		if (errors != null && !errors.isEmpty()) {
			Site tmpsite = new Site();
			tmpsite.setSiteID(siteID);
			tmpsite.setSiteName(siteName);
			tmpsite.setSitePicturesPath(fileName);
			tmpsite.setTotalSites(null);
			if (!totalSites.equals("")) {
				tmpsite.setTotalSites(Integer.valueOf(totalSites));
			}
			tmpsite.setSiteMoney(null);
			if (!totalSites.equals("")) {
				tmpsite.setSiteMoney(Integer.valueOf(siteMoney));
			}
			tmpsite.setCamp(campService.findCampByID(campID));
			
			m.addAttribute("site", tmpsite);
			return "/t4_24camp/admin/UpdateSiteByIDForm";
		}
		
		
		Site site = siteService.updateBySiteID(siteID, siteName, fileName, Integer.valueOf(totalSites), Integer.valueOf(siteMoney));
	
		m.addAttribute("site", site);
		m.addAttribute("what", "更新");
		
		return "/t4_24camp/admin/InsertUpdateSiteSuccess";
	}

}
