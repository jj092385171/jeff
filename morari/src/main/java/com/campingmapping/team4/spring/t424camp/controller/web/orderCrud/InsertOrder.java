package com.campingmapping.team4.spring.t424camp.controller.web.orderCrud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t424camp.model.entity.Order;
import com.campingmapping.team4.spring.t424camp.model.service.OrderService;
import com.campingmapping.team4.spring.utils.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/camp")
public class InsertOrder {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@PostMapping("/insertOrder.controller")
	@ResponseBody
	public Object insertOrder(@RequestParam("siteIds")@Nullable Integer[] siteIds,
			@RequestParam("nums")@Nullable Integer[] nums,
			@RequestParam("goingdate")@Nullable String goingtimeString, 
			@RequestParam("leavingdate")@Nullable String leavingtimeString,
			@RequestParam("campID")@Nullable Integer campID
			) {
		
		// 存錯誤的map
		Map<String, String> errors = new HashMap<>();
		
		//營區
		if(siteIds == null || siteIds.length == 0) {
			errors.put("siteIds", "請選擇營區");
		}
		
		//數量
		if(Arrays.asList(nums).stream().filter(num -> num > 0).count() == 0) {
			errors.put("nums", "請選擇數量");
		}
		
		//出入營日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date goingtime = null;
		Date leavingtime = null;
		try {
			goingtime = sdf.parse(goingtimeString);
			leavingtime = sdf.parse(leavingtimeString);
			if(goingtime.after(leavingtime)) {
				errors.put("timeString", "入營時間不得晚於離營時間");
			}
			if(goingtime.equals(leavingtime)) {
				errors.put("timeString", "入營時間與離營時間不得同一天");
			}
		} catch (ParseException e) {
			errors.put("timeString", "錯誤日期格式");
			e.printStackTrace();
		}
		
		//使用者
		Integer uid = jwtService.getUId(httpServletRequest);
		
		Order order = orderService.insert(uid, siteIds, nums, goingtime, leavingtime, campID);
		if(order == null) {
			System.out.println("broken");
			errors.put("order", "訂單新增失敗");
		}
		
		return order;
	}

}
