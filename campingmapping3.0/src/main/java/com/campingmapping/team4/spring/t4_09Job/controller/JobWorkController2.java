package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobWorkBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobWorkService;

@Controller
public class JobWorkController2 {
	@Autowired
	private JobWorkService jobWorkService;

	@PostMapping(path = "/showAll.controller")
	public String processAction(Model m) {
		List<JobWorkBean> showAllJob = jobWorkService.showAllJob();
		m.addAttribute("showAllJob", showAllJob);
		return "t4_09job/job/JobModel/showAll";
	}

	@GetMapping(path = "/img.controller/{id}")
	@ResponseBody
	public byte[] processAction2(@PathVariable("id") String rackID, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		int parseID = Integer.parseInt(rackID);
		JobWorkBean result = jobWorkService.findImgByRackID(parseID);
		Blob img = result.getImg();
		InputStream binaryStream = img.getBinaryStream();
		return IOUtils.toByteArray(binaryStream);
	}

	@PostMapping(path = "/delete.controller")
	public String processAction3(@RequestParam("de") String rackID) {
		int parseID = Integer.parseInt(rackID);
		jobWorkService.deleteJob(parseID);
		return "t4_09job/job/JobModel/deleteSucces";
	}

	@PostMapping(path = "/select.controller")
	public String processMainAction() {
		return "t4_09job/job/JobModel/select";
	}

	@PostMapping(path = "/selectLike.controller")
	public String processAction4(@RequestParam("job") String job, Model m) {
		Map<String, String> errorMessage = new HashMap<>();
		m.addAttribute("errors", errorMessage);
		List<JobWorkBean> result = jobWorkService.findJobByJobLike(job);
		if (result.size() == 0) {
			errorMessage.put("job", "查無資料");
			return "t4_09job/job/JobModel/select";
		}
		m.addAttribute("jobBean", result);
		return "t4_09job/job/JobModel/showSelect";
	}

	@PostMapping(path = "/selectUid.controller")
	public String processAction5(@RequestParam("uID") String uID, Model m) {
		Map<String, String> errorMessage = new HashMap<>();
		m.addAttribute("errors", errorMessage);
		try {
			int uid = Integer.parseInt(uID);
			List<JobWorkBean> result = jobWorkService.findBeanByuID(uid);
			if (result.size() == 0) {
				errorMessage.put("uID", "查無資料");
				return "t4_09job/job/JobModel/select";
			}
			m.addAttribute("jobBean", result);
			return "t4_09job/job/JobModel/showSelect";
		} catch (Exception e) {
			errorMessage.put("uID", "輸入格式錯誤");
			return "t4_09job/job/JobModel/select";
		}

	}
}
