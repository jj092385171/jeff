package com.campingmapping.team4.spring.t436mall.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t436mall.model.dao.repository.CategoryRepository;
import com.campingmapping.team4.spring.t436mall.model.entity.Category;
import com.campingmapping.team4.spring.t436mall.model.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryRepository cDao;
	
	@Autowired
	public UserRepository uDao;

	// 新增一筆產品
	@Override
	public Category createorupdata(Category category) {
		Date now = new Date();
		category.setPdlastupdate(now);
		category.setPddate(now);
		UserProfiles userid = category.getUserprofiles();
		category.setUserprofiles(userid);
		return cDao.save(category);
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
