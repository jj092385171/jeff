package com.campingmapping.team4.spring.t436mall.controller.web;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductCartVoRequest;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrder;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrderVo;
import com.campingmapping.team4.spring.t436mall.model.service.impl.ProductOrderServiceImpl;

@RestController
@RequestMapping("/ProductOrder")
public class ProductOrderController {

	@Autowired
	private ProductOrderServiceImpl pOServiceImpl;

	// 根據購物車新增一筆訂單
	@PostMapping("/create")
	public ProductOrder create(@RequestBody List<ProductCartVoRequest> productcartvorequest,
			@RequestParam("odrecipient") String odrecipient,
			@RequestParam("odrecipientphone") String odrecipientphone,
			@RequestParam("odshippingaddress") String odshippingaddress,
			@RequestParam("money") Integer money) {
		return pOServiceImpl.create(productcartvorequest, odshippingaddress, odshippingaddress, odshippingaddress, money);
	}
	// 依orderID來搜尋單筆訂單
	@GetMapping("/selectById/{id}")
	public List<ProductOrderVo> selectById(@PathVariable String id) {
		return pOServiceImpl.selectById(id);
	}
	// 依userID來搜尋所有訂單
	@GetMapping("/selectAllByUserId/{userid}")
	public List<ProductOrder> selectAllByUserId(@PathVariable Integer userid) {
		return pOServiceImpl.selectAllByUserId(userid);
	}
	// 搜尋所有訂單(只有後臺能使用)
	@GetMapping("/selectAll")
	public List<ProductOrder> selectAll() {
		return pOServiceImpl.selectAll();
	}
	// 修改訂單狀態
	@PutMapping("/updateProductOrderSatusById")
	public void updateProductOrderSatusById(@RequestParam String orderStatus,
			@RequestParam Timestamp newDate, @RequestParam String orderId) {
		pOServiceImpl.updateProductOrderSatusById(orderStatus, newDate,
				orderId);
	}
	// 修改訂單出貨地址、收件人、手機號(只有後臺能使用)
	@PutMapping("/updateById")
	public ProductOrder updateById(@PathVariable ProductOrder productorder) {
		return pOServiceImpl.updateById(productorder);
	}
	// 依userID來修改單筆產品(只有後臺能使用)

}
