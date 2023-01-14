package com.campingmapping.team4.spring.t436mall.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductCart;
import com.campingmapping.team4.spring.t436mall.model.service.impl.ProductCartServiceImpl;

@RestController
@RequestMapping("/ProductCart")
public class ProductCartController {

	@Autowired
	private ProductCartServiceImpl PCServiceImpl;

	// 依userid新增一筆購物車資料
	@PostMapping("/create")
	public ProductCart create(@RequestBody ProductCart productcart,@PathVariable int pdid) {
		return PCServiceImpl.create(productcart,pdid);
	}
	// 依cartid來增加or減少購物車產品數量
	@PutMapping("/updataById")
	public ProductCart updataById(@RequestBody ProductCart productcart) {
		return PCServiceImpl.updataById(productcart);
	}
	// 清空購物車
	@DeleteMapping("/deleteByUserId")
	public void deleteByUserId(@PathVariable int id) {
		PCServiceImpl.deleteByUserId(id);
	}
	// 結帳->新增訂單
	@DeleteMapping("/checkout")
	public void checkout(@PathVariable int id) {
		PCServiceImpl.checkout(id);
	}
	// 依userID查詢購物車資料
	@GetMapping("/selectAllByUserId")
	public List<ProductCart> selectAllByUserId(@PathVariable Integer userid) {
		return PCServiceImpl.selectAllByUserId(userid);
	}
	// 查詢購物車所有資料(後台)
	@GetMapping("/selectAll")
	public List<ProductCart> selectAll() {
		return PCServiceImpl.selectAll();
	}
}
