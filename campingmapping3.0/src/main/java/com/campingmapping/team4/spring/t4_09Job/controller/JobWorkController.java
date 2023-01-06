package com.campingmapping.team4.spring.t4_09Job.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobWorkBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobWorkService;

@Controller
public class JobWorkController {

	@Autowired
	private JobWorkService jobWorkService;
	
	@PostMapping(path = "/JobServletAdd")
	public String insert(@RequestParam("uid") String uid,
			@RequestParam("job") String job,@RequestParam("salary") String salary,
			@RequestParam("quantity") String quantity,@RequestParam("place")String place,
			@RequestParam("time") String time,@RequestParam("date") String date,
			@RequestParam("rackUp") String rackUp,@RequestParam("rackDown") String rackDown, 
			@RequestParam("img") String img,@RequestParam("remark") String remark,Model m) {
		
		Map<String, String> errorMessage = new HashMap<>();
		m.addAttribute("errors", errorMessage);
		// 驗證會員id輸入格式
				try {
					Integer uID = Integer.parseInt(uid);
				} catch (Exception e) {
					errorMessage.put("id", "輸入格式錯誤");
				}
		return "";
		}
}

