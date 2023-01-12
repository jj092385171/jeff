package com.campingmapping.team4.spring.t436mall.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t436mall.model.dao.repository.CategoryRepository;
import com.campingmapping.team4.spring.t436mall.model.entity.Category;
@Service
public class CategoryServiceImpl {

	@Autowired
	public CategoryRepository cDao;

	// 新增一筆產品或修改單筆產品
	public Category createorupdata(Category category) {
		return cDao.save(category);
	}

	// 依Pdid來刪除單筆產品
	public void deleteByPdid(int id) {
		cDao.deleteById(id);
	}

	// 依Pdid來修改單筆產品
	// public void updateByPdid(Category category) {
	// cDao.save(category);
	// }

	// 依Pdid來搜尋單筆產品
	public Category selectByPdid(int Pdid) {
		return cDao.findById(Pdid).orElse(null);
	}

	// 搜尋所有產品
	public List<Category> selectAllPd() {
		return cDao.findAll();
	}

	// 根據購買修改庫存
	public void updateBuy(List<Category> category) {

		for (Category buy : category) {
			Category inventory = cDao.findById(buy.getPdid()).get();
			inventory.setPdinventory(
					inventory.getPdinventory() - buy.getPdinventory());
			cDao.save(inventory);
		}
	}

}
