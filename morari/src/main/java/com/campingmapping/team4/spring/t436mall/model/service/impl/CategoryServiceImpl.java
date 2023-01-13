package com.campingmapping.team4.spring.t436mall.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t436mall.model.dao.repository.CategoryRepository;
import com.campingmapping.team4.spring.t436mall.model.entity.Category;
import com.campingmapping.team4.spring.t436mall.model.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryRepository cDao;
	
	@Autowired
	public UserRepository userDao;
	
	// 新增一筆產品
	@Override
	public Category create(Category category ,Integer uid) {
		Date now = new Date();
		category.setPdlastupdate(now);
		category.setPddate(now);
		category.setUserprofiles(userDao.findById(uid).get());
		
		cDao.save(category);
		
		return category;
	}

	// 依Pdid來刪除單筆產品
	@Override
	public void deleteByPdid(int id) {
		cDao.deleteById(id);
	}

	// 依Pdid來修改單筆產品
	@Override
	public Category updateByPdid(Category category) {
		Date now = new Date();
		category.setPdlastupdate(now);
		return cDao.save(category);
	}

	// 依Pdid來搜尋單筆產品
	@Override
	public Category selectByPdid(int Pdid) {
		return cDao.findById(Pdid).orElse(null);
	}

	// 搜尋所有產品
	@Override
	public List<Category> selectAll() {
		return cDao.findAll();
	}

	// 根據購買減少庫存
	@Override
	public void updateBuy(List<Category> category) {

		for (Category buy : category) {
			Category inventory = cDao.findById(buy.getId()).get();
			inventory.setPdinventory(inventory.getPdinventory() - buy.getPdinventory());
			cDao.save(inventory);
		}
	}

}
