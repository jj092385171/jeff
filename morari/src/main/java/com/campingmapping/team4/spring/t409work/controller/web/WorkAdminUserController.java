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
import com.campingmapping.team4.spring.t409work.model.service.MailService;
import com.campingmapping.team4.spring.utils.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

//job職缺(營主)的後台
@Controller
@RequestMapping("/admin/user/work")
public class WorkAdminUserController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JobService jService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private MailService mailService;

	// 啟動我的首頁
	@GetMapping("/startCrud.controller")
	public String processMainAction1() {
		return "work/admin/camp/userCrud";
	}

	// 啟動insert
	@PostMapping("/startInsert.controller")
	public String processMainAction2() {
		return "work/admin/camp/userInsert";
	}

	// 啟動select
	@PostMapping("/startSelect.controller")
	public String processMainAction3() {
		return "work/admin/camp/userSelect";
	}

	// 啟動update
	@PostMapping("/startUpdate.controller/{u}")
	public String processMainAction4() {
		return "work/admin/camp/userUpdate";
	}

	// 透過uid搜尋
	@PostMapping("/userSelectUid.controller/{uid}")
	@ResponseBody
	public List<JobBean> processSelectUidAction(@PathVariable UUID uid) {
		List<JobBean> result = jService.findUid(uid);
		// if (result.size() == 0) {
		// return null;
		// }
		return result;
	}

	// 新增
	@PostMapping("/userInsert.controller")
	@ResponseBody
	public JobBean processInsertAction2(@RequestBody JobBean jobBean) {
		UUID uid = jwtService.getUId(request);
		return jService.insert(jobBean, uid);
	}

	// 刪除
	@DeleteMapping("/userDelete.controller/{rackID}")
	@ResponseBody
	public String processDeleteAction(@PathVariable Integer rackID) {
		jService.deleteById(rackID);
		return "ok";
	}

	// 修改
	@PutMapping("/userUpdate.controller/{rackid}")
	@ResponseBody
	public JobBean processUpdateAction(@RequestBody JobBean jBean, @PathVariable Integer rackid) {
		System.out.println("rackid=" + rackid);
		return jService.updateJob(jBean, rackid);
	}

	// 透過rackid找資料後給前端修改
	@PostMapping("/userSelectRackId.controller/{rackID}")
	@ResponseBody
	public JobBean processAction4(@PathVariable Integer rackID) {
		JobBean result = jService.findById(rackID);
		return result;
	}

	// 寄email
	@PostMapping("/userMail.controller")
	@ResponseBody
	public String processAction4(@RequestBody String email) {
		mailService.sendEmail(email, "快加入我們吧！", "您好，我明天要睡飽一點會晚到，不要太想我");

		return "Success！！！";
	}

}
