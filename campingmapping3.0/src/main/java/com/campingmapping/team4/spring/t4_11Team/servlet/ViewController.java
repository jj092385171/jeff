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
	
	@GetMapping("/showallcamparea.controller")
	@ResponseBody
	public List<Initiating> selectAllCamparea(){
		List<Initiating> allcamparea = teamService.selectAllCamparea();
		return allcamparea;
	}
	
	@GetMapping("/showallpostmember.controller")
	@ResponseBody
	public List<Initiating> showAllpostmember(){
		List<Initiating> allpostmember = teamService.selectAllMember();
		return allpostmember;
	}
	
	@PostMapping("/insertMaterial.controller")
	@ResponseBody
	public String insert(@RequestBody Initiating i) {
		System.out.println("1"+i.getCurrentnum());
		System.out.println("2"+i.getAcceptablenum());
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
		Initiating in = teamService.findById(initiating.getInitiatingnum());
		initiating.setPostdate(in.getPostdate());
		teamService.updateInitiating(initiating);
		return "update OK";
	}
	
}