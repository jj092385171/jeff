package com.campingmapping.team4.spring.t409work.controller.web;

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

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t409work.model.entity.JobBean;
import com.campingmapping.team4.spring.t409work.model.service.JobService;

@Controller
@RequestMapping("/work")
public class WorkPageComtroller {

	@Autowired
	private JobService jService;

	@GetMapping({ "", "/" })
	public String workIndex() {
		return "work/guest/index";
	}

	@GetMapping("/jobIndex.controller")
	public String processMainAction() {
		return "t4_09job/job/jobIndex";
	}

	@GetMapping("/jobCRUD.controller")
	public String processMainAction1() {
		return "t4_09job/job/JobModel/jobCRUD";
	}

	@PostMapping("/insert.controller")
	public String processMainAction2() {
		return "t4_09job/job/JobModel/insert";
	}

	@PostMapping("/select.controller")
	public String processMainAction3() {
		return "t4_09job/job/JobModel/select";
	}

	// 還未寫完
	@GetMapping("/jobInsert.controller")
	@ResponseBody
	public JobBean processInsertAction2(@RequestBody JobBean jBean) {
		jService.insert(jBean);
		return jBean;
	}

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

	@GetMapping("/jobDelete.controller")
	public String processDeleteAction(@RequestParam("de") String rackID) {
		int parseID = Integer.parseInt(rackID);
		jService.deleteById(parseID);
		return "ok";
	}

	@PostMapping("/selectLike.controller")
	@ResponseBody
	public List<JobBean> processSelectlikeAction(@RequestParam("job") String job) {
		List<JobBean> result = jService.findByJobisLike(job);
		if (result.size() == 0) {// 在前面判斷 再給查無此資料字串到html
			return null;
		}
		return result;
	}

	//還沒寫完
	@PostMapping("/selectUid.controller")
	@ResponseBody
	public List<JobBean> processSelectUidAction(@RequestParam("uID") UserProfiles userprofiles) {
		List<JobBean> result = jService.findByUid(userprofiles);
		if (result.size() == 0) {
			return null;
		}
		return result;
	}
	
	//透過rackid找資料後給前端修改
	@PostMapping( "/selectRackId.controller")
	public JobBean processAction4(@RequestParam("up") Integer rackID) {
		JobBean result = jService.findById(rackID);
		return result;
	}
	
	//還未寫完,圖片在這裡轉成byte
	@GetMapping("/jobUpdate.controller")
	@ResponseBody
	public JobBean processUpdateAction(@RequestBody JobBean jBean) {
		jService.insert(jBean);
		return jBean;
	}
}
