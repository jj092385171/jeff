package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
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

	@PostMapping(path = "/update.controller")
	public String controllerInsert(@RequestParam("uid") String uid, @RequestParam("job") String job,
			@RequestParam("salary") String salary, @RequestParam("quantity") String quantity,
			@RequestParam("place") String place, @RequestParam("time") String time, @RequestParam("date") String date,
			@RequestParam("rackUp") String rackUp, @RequestParam("rackDown") String rackDown,
			@RequestParam("img") MultipartFile img, @RequestParam("remark") String remark, Model m) throws IOException {

		List<JobWorkBean> showAllJob = jobWorkService.showAllJob();
		m.addAttribute("showAllJob", showAllJob);
		JobWorkBean j = new JobWorkBean();
		return "";
	}

}
