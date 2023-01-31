package com.campingmapping.team4.spring.t409work.controller.web;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t409work.model.service.JobService;

//job職缺(營主)的後台
@Controller
@RequestMapping("/admin/user/work")
public class WorkAdminUserController {
	@Autowired
	private JobService jService;

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
	public List<JobBean> processSelectUidAction(@PathVariable Integer uid) {
		List<JobBean> result = jService.findUid(1);
//		if (result.size() == 0) {
//			return null;
//		}
		return result;
	}

	// 新增
	@PostMapping("/userInsert.controller")
	@ResponseBody
	public JobBean processInsertAction2(@RequestBody JobBean jobBean) {
		return jService.insert(jobBean, 1);
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

	// 模糊搜尋+uid
	@PostMapping("/selectLikeAnd.controller/{job}")
	@ResponseBody
	public List<JobBean> processSelectlikeAction(@PathVariable String job) {
		List<JobBean> result = jService.findByUidAndJobisLike(1, job);
		return result;

	}
}
