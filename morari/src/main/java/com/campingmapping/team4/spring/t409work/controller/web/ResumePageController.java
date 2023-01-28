package com.campingmapping.team4.spring.t409work.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t409work.model.entity.ResumeBean;
import com.campingmapping.team4.spring.t409work.model.service.ResumeService;

@Controller
@RequestMapping("/admin/resume")
public class ResumePageController {

	@Autowired
	private ResumeService rService;

	// 啟動insert
	@PostMapping("/insert.controller")
	public String processMainAction2() {
		return "resume/admin/insert";
	}

	// 啟動select
	@PostMapping("/select.controller")
	public String processMainAction3() {
		return "resume/admin/select";
	}

	// 啟動update
	@PostMapping("/update.controller/{u}")
	public String processMainAction4() {
		return "resume/admin/update";
	}

	// 新增
	@PostMapping("/resumeInsert.controller")
	@ResponseBody
	public ResumeBean processInsertAction2(@RequestBody ResumeBean rBean) {
		return rService.insert(rBean, 2);
	}
	
	// 刪除
	@DeleteMapping("/jobDelete.controller/{number}")
	@ResponseBody
	public String processDeleteAction(@PathVariable Integer number) {
		rService.deleteById(number);
		return "ok";
	}
	
	// 修改
	@PostMapping("/resumeUpdate.controller")
	@ResponseBody
	public ResumeBean processUpdateAction(@RequestBody ResumeBean rBean) {
		return rService.updateJob(rBean);
	}
	
	// 找全部 
	@PostMapping("/resumeShowAll.controller")
	@ResponseBody
	public List<ResumeBean> processShowResumeAllAction() {
		List<ResumeBean> result = rService.findAll();
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
	@PostMapping("/selectUid.controller/{uid}")
	@ResponseBody
	public List<ResumeBean> processSelectUidAction(@PathVariable Integer uid) {
		List<ResumeBean> result = rService.findRid(uid);
		if (result.size() == 0) {
			return null;
		}
		return result;
	}

	// 透過rackid搜尋(在企業主端秀出來用)
	@PostMapping("/selectRid.controller/{rackid}")
	@ResponseBody
	public List<ResumeBean> processSelectRidAction(@PathVariable Integer rackid) {
		List<ResumeBean> result = rService.findRid(rackid);
		if (result.size() == 0) {
			return null;
		}
		return result;
	}

}
