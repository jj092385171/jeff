package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobWorkBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobWorkService;

@Controller
public class JobWorkController3 {
	@Autowired
	private JobWorkService jobWorkService;

	@PostMapping(path = "/selectRackId.controller")
	public String processAction4(@RequestParam("up") String rackID, Model m) {
		int rackId = Integer.parseInt(rackID);
		JobWorkBean result = jobWorkService.findBeanByRackID(rackId);
		m.addAttribute("JobBean", result);
		return "t4_09job/job/JobModel/update";
	}

	@PostMapping(path = "/update.controller")
	public String controllerInsert(@RequestParam("rackID") String rackID, @RequestParam("uid") String uid,
			@RequestParam("job") String job, @RequestParam("salary") String salary,
			@RequestParam("quantity") String quantity, @RequestParam("place") String place,
			@RequestParam("time") String time, @RequestParam("date") String date, @RequestParam("rackUp") String rackUp,
			@RequestParam("rackDown") String rackDown, @RequestParam("img") MultipartFile img,
			@RequestParam("remark") String remark, Model m) throws IOException {

		Map<String, String> errorMessage = new HashMap<>();
		m.addAttribute("errors", errorMessage);

		JobWorkBean j = new JobWorkBean();
		Integer rackId = Integer.parseInt(rackID.trim());
		
		// 處理照片格式
		InputStream in = img.getInputStream();
		long size = img.getSize();
		try {
			Blob image = jobWorkService.fileToBlob(in, size);
			j = jobWorkService.findBeanByRackID(rackId);
			if (size != 0) {
				j.setImg(image);
			}
		} catch (Exception e) {
		}
		
		// 驗證uid輸入格式
		try {
			Integer uID = Integer.parseInt(uid);	
			j.setuID(uID);
		} catch (Exception e) {
			errorMessage.put("id", "輸入格式錯誤");
			return "t4_09job/job/JobModel/update";
		}

		// 驗證人數輸入格式
		try {
			Integer q = Integer.parseInt(quantity);
			j.setQuantity(q);
		} catch (Exception e) {
			errorMessage.put("quantity", "輸入格式錯誤");
			return "t4_09job/job/JobModel/update";
		}

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

		j.setJob(job);
		j.setSalary(salary);
		j.setPlace(place);
		j.setTime(time);
		j.setDate(date);
		j.setRemark(remark);
		
		jobWorkService.updateJob(j);
		m.addAttribute("JobBean", j);
		return "t4_09job/job/JobModel/updateSucces";

	}

}
