package com.campingmapping.team4.spring.t411team.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
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

import com.campingmapping.team4.spring.t411team.model.entity.Initiating;
import com.campingmapping.team4.spring.t411team.model.entity.MessageArea;
import com.campingmapping.team4.spring.t411team.model.entity.Thundsup;
import com.campingmapping.team4.spring.t411team.model.service.teamService;
import com.campingmapping.team4.spring.utils.config.GoogleFileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/team")
public class TeamPageComtroller {
	
	@GetMapping({ "", "/" })
	public String teamIndex() {
		return "team/guest/index";
	}
	
	@Autowired
	private teamService teamService;
	
	@Autowired
	private GoogleFileUtil googleFileService;
	
	@RequestMapping("/teammanager.controller")
	public String  processmainAction() {
		return "team/admin/teammanager";
	}
	
	@RequestMapping("/insert.controller")
	public String intoInsertAction() {
		return "team/admin/insertManager";
	}
	
	@GetMapping("/view.controller")
	@ResponseBody
	public List<Initiating> showAll() throws JsonProcessingException{
		List<Initiating> view = teamService.findAll();
		return view;
	}
	
	@GetMapping("/viewPaging.controller/{page}")
	@ResponseBody
	public List<Initiating> showAllpage(@PathVariable("page")@Nullable String page) throws JsonProcessingException{
		int pagenum = Integer.valueOf(page.substring(1,page.length()-1));
		
		Pageable pageable = PageRequest.of(pagenum - 1, 5);
		Page<Initiating> view = teamService.findAllpage(pageable);
		return view.getContent();
	}
	
	@PostMapping("/insertMaterial.controller/{uid}")
	@ResponseBody
	public String insert(@RequestBody Initiating i , @PathVariable UUID uid) {
		teamService.insert(i, uid);
		return "Insert OK";
	}
	
	@DeleteMapping("/delete.controller/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") String id) {
		String initiatingnum = id.substring(1,id.length()-1);
		teamService.delete(Integer.valueOf(initiatingnum));
		return "Delete OK";
	}
	
	@GetMapping("/update.controller")
	public String display() {
		return "team/admin/updateManager";
	}
	
	@PutMapping("/updateMaterial.controller")
	@ResponseBody
	public String update(@RequestBody Initiating i) {
		Initiating in = teamService.findById(i.getInitiatingnum());
		i.setPostdate(in.getPostdate());
		i.setUserprofiles(in.getUserprofiles());
		teamService.update(i);
		return "update OK";
	}
	
	@PostMapping("/select.controller/{uid}")
	@ResponseBody
	public List<Initiating> select(@RequestBody Initiating i, @PathVariable String uid){
		List<Initiating> result = new ArrayList<>();
		
		if(i.getInitiatingnum()!=0) {
			Initiating uidResult = teamService.findById(i.getInitiatingnum());
			result.add(uidResult);
		}else {
			String id = uid.substring(1, uid.length()-1);
			List<Initiating> selectResult = teamService.selectDynamic(id, i.getStartdate(), i.getEnddate(), i.getCamparea());
			result.addAll(selectResult);
		}
		return result;
	}
	
	@PostMapping("/findById.controller/{id}")
	@ResponseBody
	public Initiating findById(@PathVariable("id") String id){
		String initiatingnum = id.substring(1,id.length()-1);
		Initiating result = teamService.findById(Integer.valueOf(initiatingnum));
		return result;
	}
	
	@PostMapping("/thumbsUp.controller/{uid}")
	@ResponseBody
	public String thumbsUp(@RequestBody @Nullable String[] arr,@PathVariable UUID uid) {
		int x;
		for(int i = 0; i < arr.length; i++) {
			System.out.println("我要按讚");
			System.out.println(uid);
			x = Integer.valueOf(arr[i]);
			System.out.println(x);
			if (x < 0) {
				x = 0-x;
				System.out.println(x);
				List<Thundsup> selectresult = teamService.selectThundsup(x, uid);
				if(selectresult != null) {
					for (Thundsup thundsup : selectresult) {
						Integer tid = thundsup.getThundsupid();
						teamService.deleteThundsup(tid);
						Initiating initiating = teamService.findById(x);
						initiating.setThumbsUp(initiating.getThumbsUp()-1);
						teamService.update(initiating);
					}
				}
			}else {
				System.out.println(x);
				List<Thundsup> selectresult = teamService.selectThundsup(x, uid);
				if (selectresult == null) {
					teamService.insertThundsup(x, uid);
					Initiating initiating = teamService.findById(x);
					initiating.setThumbsUp(initiating.getThumbsUp()+1);
					teamService.insertThundsup(x, uid);
				}
			}
			
			System.out.println("完成一圈");
		}
		
		System.out.println("按讚成功");
		return "ok";
	}
	
	//查詢案讚數
	@GetMapping("/selectThumbsUp.controller/{uid}")
	@ResponseBody
	public List<Thundsup> findThumbsUpByUser(@PathVariable UUID uid){
		return teamService.findThumbsUpByid(uid);
	}
	
	//更多資訊跳轉
	@GetMapping("/moreInformation.controller/{num}")
	public String moreinformation(@PathVariable Integer num) {
		Initiating i = teamService.findById(num);
		i.setViewingCount(i.getViewingCount()+1);
		teamService.update(i);
		return "team/guest/initiatingform";
	}
	
	//顯示本人留言
	@GetMapping("/selectMessage.controller/{num}")
	@ResponseBody
	public List<MessageArea> selectMessage(@PathVariable String num){
		Integer mid = Integer.valueOf(num.substring(1,num.length()-1));
		return teamService.selectByMid(mid);
	}
	
	//新增留言
	@PostMapping("/insertMessage.controller/{uid}")
	@ResponseBody
	public List<MessageArea> insertMessage(@RequestBody String[] messageArr,@PathVariable UUID uid){
		teamService.insertMessasge(uid, Integer.valueOf(messageArr[0]), messageArr[1]);
		return null;
	}
	
	//刪除留言
	@PostMapping("/deleteMessage.controller/{mid}")
	@ResponseBody
	public String deleteMessage(@PathVariable Integer mid) {
		teamService.deleteMessage(mid);
		return "delete OK";
	}
	
	//回傳img的google位址
	@PostMapping("/getGoogledriveSrc.controller")
	public String getGoogledriveSrc(@RequestParam MultipartFile file) {
		return null;
	}

}
