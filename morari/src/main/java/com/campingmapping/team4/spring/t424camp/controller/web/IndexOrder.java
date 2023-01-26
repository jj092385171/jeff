package com.campingmapping.team4.spring.t424camp.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t424camp.model.entity.Order;
import com.campingmapping.team4.spring.t424camp.model.service.OrderService;


@Controller
@RequestMapping("/admin/camp")
public class IndexOrder {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/orderindex")
	public String showOrderIndex() {
		return "camp/admin/AdminOrderIndex";
	}
	
	@GetMapping("/showAllOrders/{page}")
	@ResponseBody
	public Map<String, Object> showAllOrder(@PathVariable("page")@Nullable Integer page ) {
		if(page == null) {
			page = 1;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageSize = 3;
		Pageable pageable = PageRequest.of(page-1, pageSize);
		Page<Order> pageList = orderService.getByPage(pageable);
		
		
		List<Order> orderList = pageList.getContent();
		map.put("orderList", orderList);
		
		int totalPages = pageList.getTotalPages();
		map.put("totalPages", totalPages);
		
		long totalOrders = pageList.getTotalElements();
		map.put("totalOrders", totalOrders);
		
		return map;
	}

}
