package com.campingmapping.team4.spring.t424camp.controller.web.orderCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t424camp.model.entity.Order;
import com.campingmapping.team4.spring.t424camp.model.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/camp")
public class QueryOrder {
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/querySuccessOrder")
	@ResponseBody
	public Object querySuccessOrderByID() {
		
		HttpSession session = httpServletRequest.getSession();
		
		Order order = (Order) session.getAttribute("successOrder");
		
		order.setStatus("訂單付款成功");
		
		return orderService.update(order);
	}

}
