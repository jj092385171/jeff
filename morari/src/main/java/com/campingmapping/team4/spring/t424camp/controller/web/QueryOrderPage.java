package com.campingmapping.team4.spring.t424camp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/camp")
public class QueryOrderPage {
	
	@GetMapping("/queryOrder")
	public String AdminOrderIndex() {
		return "camp/admin/AdminOrderIndex" ;
	}
	
	@GetMapping("/querySuccessOrderPage")
	public Object toOrderSuccess() {
		return "camp/admin/OrderSuccess";
	}
	
	

}
