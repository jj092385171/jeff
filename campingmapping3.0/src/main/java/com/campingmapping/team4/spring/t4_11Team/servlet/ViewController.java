package com.campingmapping.team4.spring.t4_11Team.servlet;

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

import com.campingmapping.team4.spring.t4_11Team.controller.TService;
import com.campingmapping.team4.spring.t4_11Team.model.Initiating;
import com.fasterxml.jackson.core.JsonProcessingException;


@Controller
public class ViewController {
	
	@Autowired
	private TService teamService;
	
	@RequestMapping("/team.controller")
	public String  processmainAction() {
		return "teammanager";
	}
	
	@RequestMapping("/insert.controller")
	public String intoInsertAction() {
		return "insert";
	}
	
	@GetMapping("/view.controller")
	@ResponseBody
	public List<Initiating> showAll() throws JsonProcessingException{
		List<Initiating> view = teamService.selectAllInitiating();
		return view;
	}
	
	@PostMapping("/insertMaterial.controller")
	@ResponseBody
	public String insert(@RequestBody Initiating i) {
		teamService.insertInitiating(i);
		return "Insert OK";
	}
	
	@DeleteMapping("/delete.controller/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") String id) {
		String initiatingnum = id.substring(1,id.length()-1);
		teamService.deleteInitiating(Integer.valueOf(initiatingnum));
		return "Delete OK";
	}
	
	@GetMapping("/update.controller")
	public String display() {
		return "update";
	}
	
	@PutMapping("/updateMaterial.controller")
	@ResponseBody
	public String update(@RequestBody Initiating initiating) {
		teamService.updateInitiating(initiating);
		return "update OK";
	}
	
}
