package com.campingmapping.team4.spring.t436mall.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t436mall.model.entity.Category;
import com.campingmapping.team4.spring.t436mall.model.service.impl.CategoryServiceImpl;

@Controller
@RequestMapping("/mall")
public class MallPageComtroller {

	@GetMapping({ "", "/" })
	public String mallIndex() {
		return "mall/admin/index";
	}

	@Autowired
	private CategoryServiceImpl cServiceImpl;
	
	@GetMapping("/productqueryallmain.controller")
	public String processQueryAllAction() {
		return "mall/admin/index";
	}
	
	@GetMapping("/productcreate.controller")
	public String processcreateAction() {
		return "mall/admin/newproduct";
	}
	
	@GetMapping("/updateproduct.controller/{id}")
	public String processupdateAction() {
		return "mall/admin/updateproduct";
	}

	// 新增一筆產品
	@PostMapping("/create.controller")
	@ResponseBody
	public String create(@RequestBody Category category ) {
		System.out.println(category.getPdid()); 
		cServiceImpl.create(category);
		return "insert ok!!";
	}

	// 搜尋所有產品
	@GetMapping("/selectAllPd")
	@ResponseBody
	public List<Category> selectAllPd() {
		return cServiceImpl.selectAll();
	}

	// 依Pdid來搜尋單筆產品
	@GetMapping("/selectByPdid/{Pdid}")
	@ResponseBody
	public Category selectByPdid(@PathVariable int Pdid) {
		return cServiceImpl.selectByPdid(Pdid);
	}

	// 依Pdid來刪除單筆產品
	@DeleteMapping("/deleteByPdid/{Pdid}")
	@ResponseBody
	public String deleteByPdid(@PathVariable int Pdid) {
		
		cServiceImpl.deleteByPdid(Pdid);
		return "刪除成功!";
	}

	// 依Pdid來修改單筆產品
	@PutMapping("/updateByPdid")
	@ResponseBody
	public String updateByPdid(@RequestBody Category category) {
		cServiceImpl.updateByPdid(category);
		return "修改成功!";
	}

}
