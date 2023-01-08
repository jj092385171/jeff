package com.campingmapping.team4.spring.t4_09Job.controller;

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
//	@GetMapping(path = "/img.controller")
//	public String processAction2(@RequestParam("de") String rackID) {
//		OutputStream os = null;
//		InputStream is = null;
//		Blob blob = null;
//		try {		
//			int parseID = Integer.parseInt(rackID);
//		
//			JobWorkBean result = jobWorkService.findImgByRackID(parseID);
//			blob = result.getImg();
//			is = blob.getBinaryStream();
//			os = response.getOutputStream();
//			int len = 0;
//			byte[] bytes = new byte[8000];
//			while ((len = is.read(bytes)) != -1) {
//			os.write(bytes, 0, len);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("失敗");
//		}finally {
//			if (is != null) is.close();
//            if (os != null) os.close();
//		}
//	}

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
