package com.campingmapping.team4.spring.t411team.controller.web;

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

import com.campingmapping.team4.spring.t411team.model.entity.Initiating;
import com.campingmapping.team4.spring.t411team.model.service.teamService;
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

	@RequestMapping("/teammanager.controller")
	public String processmainAction() {
		return "team/admin/teammanager";
	}

	@RequestMapping("/insert.controller")
	public String intoInsertAction() {
		return "team/admin/insert";
	}

	@GetMapping("/view.controller")
	@ResponseBody
	public List<Initiating> showAll() throws JsonProcessingException {
		List<Initiating> view = teamService.findAll();
		return view;
	}

	@PostMapping("/insertMaterial.controller/{uid}")
	@ResponseBody
	public String insert(@RequestBody Initiating i, @PathVariable String uid) {
		String id = uid.substring(1, uid.length() - 1);
		teamService.insert(i, null);
		return "Insert OK";
	}

	@DeleteMapping("/delete.controller/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") String id) {
		String initiatingnum = id.substring(1, id.length() - 1);
		teamService.delete(Integer.valueOf(initiatingnum));
		return "Delete OK";
	}

	@GetMapping("/update.controller")
	public String display() {
		return "team/admin/update";
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

	@PostMapping("/select.controller")
	@ResponseBody
	public List<Initiating> select(@RequestBody Initiating i) {
		// DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String uid = "";
		// Date std = sdf.parse("1900-01-01");
		// Date ed = sdf.parse("2099-12-31");

		List<Initiating> result = teamService.selectDynamic(uid, i.getStartdate(), i.getEnddate(), i.getCamparea());
		return result;
	}

}