package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobWorkBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobWorkService;

@Controller
public class JobWorkController1 {

	@Autowired
	private JobWorkService jobWorkService;
	@PostMapping(path = "/jobCRUD.controller")
	public String processMainAction() {
		return "t4_09job/job/JobModel/jobCRUD";
	}
	@PostMapping(path = "/insert.controller")
	public String processMainAction2() {
		return "t4_09job/job/JobModel/insert";
	}
	@PostMapping(path = "/jobServletAdd.controller")
	public String controllerInsert(@RequestParam("uid") String uid, @RequestParam("job") String job,
			@RequestParam("salary") String salary, @RequestParam("quantity") String quantity,
			@RequestParam("place") String place, @RequestParam("time") String time, @RequestParam("date") String date,
			@RequestParam("rackUp") String rackUp, @RequestParam("rackDown") String rackDown,
			@RequestParam("img") MultipartFile img, @RequestParam("remark") String remark, Model m) throws IOException {
		
		Map<String, String> errorMessage = new HashMap<>();
		m.addAttribute("errors", errorMessage);
		JobWorkBean j = new JobWorkBean();
		// 驗證會員id輸入格式
		try {
			Integer uID = Integer.parseInt(uid);
			j.setuID(uID);
		} catch (Exception e) {
			errorMessage.put("id", "輸入格式錯誤");
			return "t4_09job/job/JobModel/insert";
		}
		j.setJob(job);
		j.setSalary(salary);
		// 驗證人數輸入格式
		try {
			Integer q = Integer.parseInt(quantity);
			j.setQuantity(q);
		} catch (Exception e) {
			errorMessage.put("quantity", "輸入格式錯誤");
			return "t4_09job/job/JobModel/insert";
		}
		j.setPlace(place);
		j.setTime(time);
		j.setDate(date);
		// 轉日期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			j.setRackUp(sd.parse(rackUp));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// 轉日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			j.setRackDown(sdf.parse(rackDown));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// 處理照片格式(進資料庫)
		InputStream in = img.getInputStream();
		long size = img.getSize();
		try {
			Blob image = jobWorkService.fileToBlob(in, size);
			j.setImg(image);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		j.setRemark(remark);
		jobWorkService.addJob(j);
		m.addAttribute("JobBean",j);
		return "t4_09job/job/JobModel/addSuccess";
	}
}
