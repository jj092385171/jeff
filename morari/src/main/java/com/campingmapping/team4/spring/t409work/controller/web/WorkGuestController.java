package com.campingmapping.team4.spring.t409work.controller.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t409work.model.entity.ResumeBean;
import com.campingmapping.team4.spring.t409work.model.service.JobService;
import com.campingmapping.team4.spring.t409work.model.service.ResumeService;

// job的前台+resume的前台
@Controller
@RequestMapping("/guest/work")
public class WorkGuestController {
	@Autowired
	private ResumeService rService;

	@Autowired
	private JobService jService;

	// 啟動我的首頁
	@GetMapping("/")
	public String processMainAction1() {
		return "work/guest/workGuest";
	}

	// 啟動insert
	@PostMapping("/startResumeInsert.controller/{u}")
	public String processMainAction2() {
		return "work/guest/resumeInsert2";
	}

	// 啟動select
	@PostMapping("/resumeSelect.controller")
	public String processMainAction3() {
		return "work/guest/resumeSelect";
	}

	// 新增
	@PostMapping("/resumeInsert.controller/{rackid}")
	@ResponseBody
	public ResumeBean processInsertAction2(@RequestBody ResumeBean rBean,@PathVariable Integer rackid) {
		ResumeBean result = rService.insert(rBean, 2,rackid);
		System.out.println(result);
		return rService.insert(rBean,2,rackid);
	}

	// 找全部
	@PostMapping("/jobShowAll.controller")
	@ResponseBody
	public List<JobBean> processShowJobAllAction() {
		List<JobBean> result = jService.findAll();
		return result;
	}

	// 秀圖片
	@GetMapping("/jobImg.controller/{id}")
	@ResponseBody
	public InputStream processImgAction(@PathVariable("id") String rackID) throws SQLException {
		int parseID = Integer.parseInt(rackID);
		JobBean result = jService.findById(parseID);
		Blob img = result.getImg();
		InputStream binaryStream = img.getBinaryStream();
		return binaryStream;
	}

	// 處理照片格式(進資料庫)
	@PostMapping("/fileToBlob.controller")
	public void processImgAction(@RequestParam("img") MultipartFile img) throws IOException {
		JobBean jBean = new JobBean();
		InputStream in = img.getInputStream();
		long size = img.getSize();
		try {
			Blob image = jService.fileToBlob(in, size);
			jBean.setImg(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
