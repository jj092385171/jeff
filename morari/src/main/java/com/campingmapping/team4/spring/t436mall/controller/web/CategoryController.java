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

import com.campingmapping.team4.spring.t436mall.model.entity.Category;
import com.campingmapping.team4.spring.t436mall.model.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	// 新增一筆產品
	@PostMapping("/create")
	public Category create(@RequestBody Category category) {
		return categoryServiceImpl.create(category);
	}
	
	// 搜尋所有產品
	@GetMapping("/selectAllPd")
	public List<Category> selectAllPd() {
		return categoryServiceImpl.selectAll();
	}
	
	// 依Pdid來搜尋單筆產品
	@GetMapping("/getPersonById/{Pdid}")
	public Category getPersonById(@PathVariable int Pdid) {
		return categoryServiceImpl.selectByPdid(Pdid);
	}

	// 依Pdid來刪除單筆產品
	@DeleteMapping("/persons/{Pdid}")
	public void deleteByPdid(@PathVariable int Pdid) {
		categoryServiceImpl.deleteByPdid(Pdid);
	}
	
	// 依Pdid來修改單筆產品
	@PutMapping("/updateByPdid")
	public Category updateByPdid(@RequestBody  Category category) {
		return categoryServiceImpl.updateByPdid(category);
	}
	
	// 根據購買減少庫存
	@PutMapping("/updateBuy/")
	public void updateBuy(@RequestBody List<Category> category) {
		categoryServiceImpl.updateBuy(category);
	}

}
