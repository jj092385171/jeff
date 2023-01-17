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
import com.campingmapping.team4.spring.t436mall.model.entity.ProductCartVo;
import com.campingmapping.team4.spring.t436mall.model.service.impl.ProductCartServiceImpl;

@RestController
@RequestMapping("/ProductCart")
public class ProductCartController {

	@GetMapping({ "", "/" })
	public String mallIndex() {
		return "mall/guest/index";
	}
	
	@Autowired
	private ProductCartServiceImpl PCServiceImpl;

	// 依userid新增一筆購物車資料
	@PostMapping("/create")
	public ProductCart create(@RequestBody ProductCart productcart) {
		return PCServiceImpl.create(productcart);
	}
	// 依cartid來增加or減少購物車產品數量
	@PutMapping("/updataById")
	public ProductCart updataById(@RequestBody ProductCart productcart) {
		return PCServiceImpl.updataById(productcart);
	}
	// 依id刪除購物車
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable Integer id) {
		PCServiceImpl.deleteById(id);
	}
	
	// 依userid清空購物車、或結帳
	@DeleteMapping("/deleteAllByUserId/{userid}")
	public void deleteAllByUserId(@PathVariable Integer userid) {
		PCServiceImpl.deleteAllByUserId(userid);
	}
	// 依userID查詢購物車資料
	@GetMapping("/selectAllByUserId/{userid}")
	public List<ProductCartVo> selectAllByUserId(@PathVariable Integer userid) {
		return PCServiceImpl.selectAllByUserId(userid);
	}
	// 查詢購物車所有資料(後台)
	@GetMapping("/selectAllVo")
	public List<ProductCartVo> selectAllVo() {
		return PCServiceImpl.selectAllVo();
	}
}
