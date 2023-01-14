package com.campingmapping.team4.spring.t409work.controller.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t409work.model.service.JobService;

@Controller
@RequestMapping("/work")
public class WorkPageController {

	@Autowired
	private JobService jService;

	@GetMapping({ "", "/" })
	public String workIndex() {
		return "work/guest/index";
	}

	// 啟動我的首頁
	@GetMapping("/jobIndex.controller")
	public String processMainAction() {
		return "t4_09job/job/jobIndex";
	}

	// 啟動CRUD
	@GetMapping("/jobCRUD.controller")
	public String processMainAction1() {
		return "t4_09job/job/JobModel/jobCRUD";
	}

	// 啟動insert
	@PostMapping("/insert.controller")
	public String processMainAction2() {
		return "t4_09job/job/JobModel/insert";
	}

	// 啟動select
	@PostMapping("/select.controller")
	public String processMainAction3() {
		return "t4_09job/job/JobModel/select";
	}

	// 處理照片格式(進資料庫)
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

	// 還未寫完
	@GetMapping("/jobInsert.controller")
	@ResponseBody
	public void processInsertAction2(@RequestBody JobBean jobBean) {
		JobBean jBean = new JobBean();
		UserProfiles u = new UserProfiles();
		u.setUid(1);
		jBean.setUserprofiles(u);	
		jBean.setDate(jobBean.getDate());
		jBean.setRackUp(jobBean.getRackUp());
		jBean.setRackDown(jobBean.getRackDown());
		jBean.setJob(jobBean.getJob());
		jBean.setPlace(jobBean.getPlace());
		jBean.setQuantity(jobBean.getQuantity());
	//	jBean.setImg(jobBean.getImg());
		jBean.setRemark(jobBean.getRemark());
		jBean.setSalary(jobBean.getSalary());
		jBean.setTime(jobBean.getTime());
		jBean.setSalary(jobBean.getSalary());
		
		jService.insert(jBean);

	}

	// 找全部
	@GetMapping("/jobShowAll.controller")
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

	// 刪除
	@GetMapping("/jobDelete.controller")
	public String processDeleteAction(@RequestParam("de") String rackID) {
		int parseID = Integer.parseInt(rackID);
		jService.deleteById(parseID);
		return "ok";
	}

	// 模糊搜尋
	@PostMapping("/selectLike.controller")
	@ResponseBody
	public List<JobBean> processSelectlikeAction(@RequestParam("job") String job) {
		List<JobBean> result = jService.findByJobisLike(job);
		if (result.size() == 0) {// 在前面判斷 再給查無此資料字串到html
			return null;
		}
		return result;
	}

	// 透過uid搜尋
	@PostMapping("/selectUid.controller")
	@ResponseBody
	public List<JobBean> processSelectUidAction(@RequestParam("uID") Integer uid) {
		List<JobBean> result = jService.findByUid(uid);
		if (result.size() == 0) {
			return null;
		}
		return result;
	}

	// 透過rackid找資料後給前端修改
	@PostMapping("/selectRackId.controller")
	public JobBean processAction4(@RequestParam("up") Integer rackID) {
		JobBean result = jService.findById(rackID);
		return result;
	}

	// 修改
	// 還未寫完,圖片在這裡轉成byte
	@GetMapping("/jobUpdate.controller")
	@ResponseBody
	public JobBean processUpdateAction(@RequestBody JobBean jBean) {
		jService.insert(jBean);
		return jBean;
	}
}