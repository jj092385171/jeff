package com.campingmapping.team4.spring.t436mall.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrderDetail;
import com.campingmapping.team4.spring.t436mall.model.service.impl.ProductOrderDetailServiceImpl;

@RestController
@RequestMapping("/ProductOrderDetail")
public class ProductOrderDetailController {

	@Autowired
	private ProductOrderDetailServiceImpl pODServiceImpl;

	// 搜尋所有訂單詳情
	@GetMapping("/selectAll")
	public List<ProductOrderDetail> selectAll() {
		return pODServiceImpl.selectAll();
	}
	// 根據訂單編號搜尋所有訂單詳情
	@GetMapping("/selectAllByPdorderid/{pdorderid}")
	public List<ProductOrderDetail> selectAllByPdorderid(
			@PathVariable String pdorderid) {
		return pODServiceImpl.selectAllByPdorderid(pdorderid);
	}
}
