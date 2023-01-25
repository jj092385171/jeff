package com.campingmapping.team4.spring.t424camp.controller.web.orderCrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/camp")
public class QueryOrder {
	
	@GetMapping("/OrderOfSite")
	public String queryByCityIDsResult() {
		return "camp/admin/OrderOfSite" ;
	}

}
