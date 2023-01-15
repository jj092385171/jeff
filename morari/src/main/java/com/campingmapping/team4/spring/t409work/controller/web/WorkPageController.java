package com.campingmapping.team4.spring.t409work.controller.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	@GetMapping("/insert.controller")
	public String processMainAction2() {
		return "work/insert";
	}

	// 啟動select
	@PostMapping("/select.controller")
	public String processMainAction3() {
		return "t4_09job/job/JobModel/select";
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

	//新增 ok
	@GetMapping("/jobInsert.controller/{u}")
	@ResponseBody
	public JobBean processInsertAction2(@RequestBody JobBean jobBean,@PathVariable Integer u) {
		return jService.insert(jobBean,u);

	}


	// 修改ok
	@GetMapping("/jobUpdate.controller/{u}")
	@ResponseBody
	public JobBean processUpdateAction(@RequestBody JobBean jBean,@PathVariable Integer u) {
		
		jService.updateJob(jBean, u);
		return jBean;
	}
	// 找全部 ok
	@GetMapping("/jobShowAll.controller")
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

	// 刪除
	@PostMapping("/jobDelete.controller")
	public boolean processDeleteAction(@RequestParam("de") Integer rackID) {
		jService.deleteById(rackID);
		return true;
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
	@ResponseBody
	public JobBean processAction4(@RequestParam("up") Integer rackID) {
		JobBean result = jService.findById(rackID);
		return result;
	}

}
