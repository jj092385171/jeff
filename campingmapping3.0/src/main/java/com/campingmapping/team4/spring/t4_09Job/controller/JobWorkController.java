package com.campingmapping.team4.spring.t4_09Job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobWorkBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobWorkService;

@Controller
public class JobWorkController {

	@Autowired
	private JobWorkService jobWorkService;
	
	@PostMapping(path = "/JobServletAdd")
	public String insert(@ModelAttribute("members") JobWorkBean mem2, BindingResult result, Model m2) {
		if (result.hasErrors()) {
			return "membersError";
		}
	
}
