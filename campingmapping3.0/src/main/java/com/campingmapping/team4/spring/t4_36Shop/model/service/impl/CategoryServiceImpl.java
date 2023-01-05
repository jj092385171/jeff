package com.campingmapping.team4.spring.t4_36Shop.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t4_36Shop.model.dao.CategoryDao;
import com.campingmapping.team4.spring.t4_36Shop.model.dao.impl.CategoryDaoImpl;
import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;
import com.campingmapping.team4.spring.t4_36Shop.model.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private SessionFactory factory;

	private CategoryDao categoryDao = new CategoryDaoImpl(
			factory.openSession());

	@Override
	public Category create(Category category) throws SQLException {
		return categoryDao.insert(category);
	}

	@Override
	public Boolean delete(int id) throws SQLException {
		return categoryDao.deleteByPd_id(id);
	}

	@Override
	public Category update(Category category) throws SQLException, Exception {
		return categoryDao.update(category);
	}

	@Override
	public Category select(int id) throws SQLException {
		Category category = categoryDao.selectByPdid(id);
		return category;
	}

	@Override
	public List<Category> selectAll() throws SQLException {
		List<Category> categoryList = categoryDao.selectAll();
		return categoryList;
	}
}
