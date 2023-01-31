package com.campingmapping.team4.spring.t409work.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.campingmapping.team4.spring.t409work.model.service.ResumeService;

//resume(營主)的後台
@Controller
@RequestMapping("/admin/user/resume")
public class AdminCampResumeController {

	@Autowired
	private ResumeService rService;
}
