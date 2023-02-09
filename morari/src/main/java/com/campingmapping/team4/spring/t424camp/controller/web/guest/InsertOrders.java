package com.campingmapping.team4.spring.t424camp.controller.web.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/camp")
public class InsertOrders {

	@GetMapping("/insertorders")
	public String toGuestIndex() {
		return "camp/guest/insertorders";
	}
	
}
