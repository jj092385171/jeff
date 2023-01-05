package com.campingmapping.team4.spring.t4_09Job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.campingmapping.team4.spring.t4_09Job.model.service.JobWorkService;

@Controller
public class JobWorkController {

	@Autowired
	private JobWorkService jobWorkService;
	
	
	
}
