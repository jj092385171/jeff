package com.campingmapping.team4.spring.t4_09Job.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;

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
	
	@GetMapping(path = "/showAll.controller")
	public String processAction(Model m) {
		List<JobWorkBean> showAllJob = jobWorkService.showAllJob();
		m.addAttribute("showAllJob", showAllJob);
		return "t4_09job/job/JobModel/showAll";
	}
//	@GetMapping(path = "/showAll.controller")
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
	
	@GetMapping(path = "/delete.controller")
	public String processAction3(@RequestParam("de") String rackID) {
		int parseID = Integer.parseInt(rackID); 
		jobWorkService.deleteJob(parseID);
		return "t4_09job/job/JobModel/deleteSucces";
	}
}
