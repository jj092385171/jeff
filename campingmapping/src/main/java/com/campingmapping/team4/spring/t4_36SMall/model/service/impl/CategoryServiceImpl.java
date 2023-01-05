package com.campingmapping.team4.spring.t4_36SMall.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.campingmapping.team4.spring.t4_36SMall.model.dao.CategoryDao;
import com.campingmapping.team4.spring.t4_36SMall.model.dao.impl.CategoryDaoImpl;
import com.campingmapping.team4.spring.t4_36SMall.model.entity.Category;
import com.campingmapping.team4.spring.t4_36SMall.model.service.CategoryService;

import util.HibernateUtils;

public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao categoryDao = new CategoryDaoImpl(HibernateUtils.getSessionFactory().getCurrentSession());

	@Override
	public void create(Category category) throws SQLException {
		categoryDao.insert(category);
	}

	@Override
	public void delete(int id) throws SQLException {
		categoryDao.deleteByPd_id(id);
	}

	@Override
	public void update(Category category) throws SQLException {
		categoryDao.update(category);
	}

	@Override
	public Category select(int id) throws SQLException {
		Category category = categoryDao.selectByPdid(id);
		return category;
	}

	// 透過PdiD秀圖片
	// @Override
	// public Category findImgByPdiD(int id) {
	// try {
	// DbUtils.begin();
	// Category cg = categoryDao.findImgByPdiD(id);
	// DbUtils.commit();
	// return cg;
	// } catch (SQLException e) {
	// DbUtils.rollbacl();
	// e.printStackTrace();
	// return null;
	// }
	// }

	@Override
	public List<Category> selectAll() throws SQLException {
		List<Category> categoryList = categoryDao.selectAll();
		return categoryList;
	}
}
