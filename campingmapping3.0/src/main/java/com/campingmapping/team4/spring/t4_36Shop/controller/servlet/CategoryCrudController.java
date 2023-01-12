package com.campingmapping.team4.spring.t4_36Shop.controller.servlet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;
import com.campingmapping.team4.spring.t4_36Shop.model.service.CategoryService;

@Controller
public class CategoryCrudController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/insert")
	@ResponseBody
	public Category insert(@RequestBody Category category) throws SQLException {
		return categoryService.create(category);
	}

	@GetMapping("/selectByPdid/{pdid}")
	@ResponseBody
	public Category selectByPdid(@PathVariable("pdid") int pdid)
			throws SQLException {
		Category resultBean = categoryService.select(pdid);
		return resultBean;

	}

	@GetMapping("/selectAll")
	@ResponseBody
	public List<Category> selectAll()
			throws SQLException {
		List<Category> category = categoryService.selectAll();
		return category;

	}

	@PutMapping("/update")
	@ResponseBody
	public Category update(@RequestBody Category category)
			throws SQLException, Exception {
		return categoryService.update(category);
	}

	@DeleteMapping("/delete/{pdid}")
	@ResponseBody
	public String delete(@PathVariable("pdid") int pdid) throws SQLException {
		categoryService.delete(pdid);
		return "Delete OK";
	}

}
