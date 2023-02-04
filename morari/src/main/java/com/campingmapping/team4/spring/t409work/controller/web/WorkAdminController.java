package com.campingmapping.team4.spring.t409work.controller.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t409work.model.service.JobService;
import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.campingmapping.team4.spring.t424camp.model.service.CampService;
import com.campingmapping.team4.spring.utils.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

//job職缺(管理者)的後台

@Controller
@RequestMapping("/admin/work")
public class WorkAdminController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private JobService jService;
	
	@Autowired
	private CampService campService;
	
	// 啟動我的首頁
	@GetMapping("/crud.controller")
	public String processMainAction1() {
		return "work/admin/manager/jobCrud";
	}

	// 啟動insert
	@PostMapping("/insert.controller")
	public String processMainAction2() {
		return "work/admin/manager/jobInsert";
	}

	// 啟動select
	@PostMapping("/select.controller")
	public String processMainAction3() {
		return "work/admin/manager/jobSelect";
	}

	// 啟動update
	@PostMapping("/startUpdate.controller/{u}")
	public String processMainAction4() {
		return "work/admin/manager/jobUpdate";
	}


	// 新增
	@PostMapping("/jobInsert.controller")
	@ResponseBody
	public JobBean processInsertAction2(@RequestBody JobBean jobBean) {
		UUID uid = jwtService.getUId(request);
		campService.findById(0);
		
		JobBean insert = jService.insert(jobBean, uid);
		return insert;
	}

	// 刪除
	@DeleteMapping("/jobDelete.controller/{rackID}")
	@ResponseBody
	public String processDeleteAction(@PathVariable Integer rackID) {
		jService.deleteById(rackID);
		return "ok";
	}

	// 修改
	@PutMapping("/jobUpdate.controller/{rackid}")
	@ResponseBody
	public JobBean processUpdateAction(@RequestBody JobBean jBean,@PathVariable Integer rackid) {
		return jService.updateJob(jBean,rackid);
	}

	// 透過rackid找資料後給前端修改
	@PostMapping("/selectRackId.controller/{rackID}")
	@ResponseBody
	public JobBean processAction4(@PathVariable Integer rackID) {
		JobBean result = jService.findById(rackID);
		return result;
	}

	// 找全部
	@PostMapping("/jobShowAll.controller")
	@ResponseBody
	public List<JobBean> processShowJobAllAction() {
		List<JobBean> result = jService.findAll();
		return result;
	}

	// 模糊搜尋
	@PostMapping("/selectLike.controller/{job}")
	@ResponseBody
	public List<JobBean> processSelectlikeAction(@PathVariable String job) {
		List<JobBean> result = jService.findByJobisLike(job);		
			return result;
		
	}

	// 透過uid搜尋
	@PostMapping("/selectUid.controller/{uid}")
	@ResponseBody
	public List<JobBean> processSelectUidAction(@PathVariable UUID uid) {
		List<JobBean> result = jService.findUid(uid);
		
		return result;
	}
	// 透過uid搜尋camp的東西
	@PostMapping("/selectUUid.controller/{uid}")
	@ResponseBody
	public List<Camp> processSelectUUidAction(@PathVariable UUID uid) {
		List<Camp> result = jService.findUUid(uid);
		
		return result;
	}
	// 透過campname搜尋camp的東西
	@PostMapping("/selectCampname.controller")
	@ResponseBody
	public Camp processSelectCampnameAction(@RequestBody String campname) {
		System.out.println(campname);
		Camp result = jService.findByCampisLike(campname);
		System.out.println("result="+result);
		return result;
	}

	// 秀圖片
//	@GetMapping("/jobImg.controller/{id}")
//	@ResponseBody
//	public InputStream processImgAction(@PathVariable("id") String rackID) throws SQLException {
//		int parseID = Integer.parseInt(rackID);
//		JobBean result = jService.findById(parseID);
//		Blob img = result.getImg();
//		InputStream binaryStream = img.getBinaryStream();
//		return binaryStream;
//	}
	
	// 處理照片格式(進資料庫)
//	@PostMapping("/fileToBlob.controller")
//	public void processImgAction(@RequestParam("img") MultipartFile img) throws IOException {
//		JobBean jBean = new JobBean();
//		InputStream in = img.getInputStream();
//		long size = img.getSize();
//		try {
//			Blob image = jService.fileToBlob(in, size);
//			jBean.setImg(image);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
