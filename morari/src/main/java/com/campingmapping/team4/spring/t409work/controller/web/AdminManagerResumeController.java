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

import com.campingmapping.team4.spring.t409work.model.entity.ResumeBean;
import com.campingmapping.team4.spring.t409work.model.service.ResumeService;

// resume(管理者)的後台
@Controller
@RequestMapping("/admin/resume")
public class AdminManagerResumeController {

	@Autowired
	private ResumeService rService;
	
	// 啟動我的首頁
	@GetMapping("/resumeCrud.controller")
	public String processMainAction1() {
		return "work/admin/manager/resumeCrud";
	}

	// 啟動select
	@PostMapping("/select.controller")
	public String processMainAction3() {
		return "work/admin/manager/resumeSelect";
	}

	// 啟動update
	@GetMapping("/update.controller/{number}")
	public String processMainAction4() {
		return "work/admin/manager/resumeUpdate";
	}
	
	// 啟動mail輸入
	@GetMapping("/startMail.controller/{m}")
	public String processMainAction5() {
		return "work/admin/manager/mailInsert";
	}
	
	// 刪除
	@DeleteMapping("/resumeDelete.controller/{number}")
	@ResponseBody
	public String processDeleteAction(@PathVariable Integer number) {
		rService.deleteById(number);
		return "刪除成功";
	}
	
	// 修改
	@PutMapping("/resumeUpdate.controller/{number}")
	@ResponseBody
	public ResumeBean processUpdateAction(@RequestBody ResumeBean rBean,@PathVariable Integer number) {
		return rService.updateJob(rBean,number);
	}
	
	// 找全部 
	@PostMapping("/resumeShowAll.controller")
	@ResponseBody
	public List<ResumeBean> processShowResumeAllAction() {
		List<ResumeBean> result = rService.findAll();
		System.out.println(result);
		return result;
	}
	
	// 透過number找資料後給前端修改
	@PostMapping("/selectNumber.controller/{number}")
	@ResponseBody
	public ResumeBean processAction4(@PathVariable Integer number) {
		ResumeBean result = rService.findById(number);
		return result;
	}
	
	// 透過uid搜尋
//	@PostMapping("/selectUid.controller/{uid}")
//	@ResponseBody
//	public ResumeBean processSelectUidAction(@PathVariable UUID uid) {
//		ResumeBean result = rService.findByUid(uid);
//		
//		return result;
//	}

	// 透過rackid搜尋(在企業主端秀出來用)
	@PostMapping("/selectRid.controller/{rackid}")
	@ResponseBody
	public List<ResumeBean> processSelectRidAction(@PathVariable Integer rackid) {
		List<ResumeBean> result = rService.findRid(rackid);
	
		return result;
	}

}
