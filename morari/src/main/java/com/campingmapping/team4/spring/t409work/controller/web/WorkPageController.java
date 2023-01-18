package com.campingmapping.team4.spring.t409work.controller.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t409work.model.service.JobService;

@Controller
@RequestMapping("/admin/work")
public class WorkPageController {

	@Autowired
	private JobService jService;

	@GetMapping({ "", "/" })
	public String workIndex() {
		return "work/guest/index";
	}
	// 啟動我的首頁
	@GetMapping("/crud.controller")
	public String processMainAction1() {
		return "work/admin/crud";
	}

	// 啟動CRUD
//	@GetMapping("/jobCRUD.controller")
//	public String processMainAction1() {
//		return "work/admin/jobCRUD";
//	}

	// 啟動insert
	@PostMapping("/insert.controller")
	public String processMainAction2() {
		return "work/admin/insert2";
	}

	// 啟動select
	@PostMapping("/select.controller")
	public String processMainAction3() {
		return "work/admin/select2";
	}

	// 啟動update
	@PostMapping("/update.controller/{u}")
	public String processMainAction4() {
		return "work/admin/update";
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

	// 新增
	@PostMapping("/jobInsert.controller")
	@ResponseBody
	public JobBean processInsertAction2(@RequestBody JobBean jobBean) {
		return jService.insert(jobBean, 2);
	}

	// 修改
	@PostMapping("/jobUpdate.controller")
	@ResponseBody
	public JobBean processUpdateAction(@RequestBody JobBean jBean) {	
		return jService.updateJob(jBean);
	}

	// 透過rackid找資料後給前端修改
	@PostMapping("/selectRackId.controller/{rackID}")
	@ResponseBody
	public JobBean processAction4(@PathVariable Integer rackID) {
		JobBean result = jService.findById(rackID);
		return result;
	}

	// 找全部 ok
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

	// 刪除
	@DeleteMapping("/jobDelete.controller/{rackID}")
	@ResponseBody
	public String processDeleteAction(@PathVariable Integer rackID) {
		jService.deleteById(rackID);
		return "ok";
	}

	// 模糊搜尋
	@PostMapping("/selectLike.controller/{job}")
	@ResponseBody
	public List<JobBean> processSelectlikeAction(@PathVariable String job) {
		List<JobBean> result = jService.findByJobisLike(job);
		if (result.size() == 0) {
			return null;
		}
		return result;
	}

	// 透過uid搜尋
	@PostMapping("/selectUid.controller/{uid}")
	@ResponseBody
	public List<JobBean> processSelectUidAction(@PathVariable Integer uid) {
		List<JobBean> result = jService.findUid(uid);
		if (result.size() == 0) {
			return null;
		}
		return result;
	}

	
}
