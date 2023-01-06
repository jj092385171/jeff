package com.campingmapping.team4.spring.t4_36Shop.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.campingmapping.team4.spring.t4_36Shop.model.dao.CategoryDao;
import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory factory;

	// 新增一筆記錄---
	public Category insert(Category category) {
		Session session = factory.openSession();
		session.saveOrUpdate(category);
		session.close();
		return category;
	}

	// 依Pd_id來刪除單筆記錄
	public Boolean deleteByPd_id(int id) {
		Session session = factory.openSession();
		Category category = session.get(Category.class, id);

		if (category != null) {
			session.delete(category);
			session.close();
			return true;
		}

		return false;
	}

	// 修改一筆產品資料
	public Category update(Category category) throws Exception {
		Session session = factory.openSession();
		Category updateByPdid = session.get(Category.class, category.getPdid());

		if (updateByPdid != null) {
			session.saveOrUpdate(category);
			session.close();
			return updateByPdid;
		}
		session.close();
		throw new Exception();
	}

	// 使用Pdid搜尋
	public Category selectByPdid(int Pdid) {
		Session session = factory.openSession();
		Category category = session.get(Category.class, Pdid);

		if (category != null) {
			return category;
		}
		session.close();
		return null;
	}

	// 搜尋全部
	public List<Category> selectAll() {
		Session session = factory.openSession();
		Query<Category> query = session.createQuery("from Category",
				Category.class);
		List<Category> resultList = query.getResultList();
		session.close();
		return resultList;
	}

}
