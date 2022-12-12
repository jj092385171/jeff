package T4_36.service.impl;

import T4_36.dao.CategoryDao;
import T4_36.dao.impl.CategoryDaoImpl;
import T4_36.entity.Category;
import T4_36.service.CategoryService;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void create(Category category) {
		try {
			DbUtils.begin();
			if (categoryDao.insert(category)) {
				DbUtils.commit();
			}
		} catch (SQLException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			DbUtils.begin();
			categoryDao.deleteByPd_id(id);
			DbUtils.commit();
		} catch (SQLException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
	}

	public void update(Category category) {
		try {
			DbUtils.begin();
			categoryDao.update(category);
			DbUtils.commit();
		} catch (SQLException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
	}

	@Override
	public Category select(int id) {
		Category category = null;
		try {
			DbUtils.begin();
			category = categoryDao.selectByPd_id(id);
			DbUtils.commit();
		} catch (SQLException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
		return category;
	}

	// 透過PdiD秀圖片
	@Override
	public Category findImgByPdiD(int id) {
		try {
			DbUtils.begin();
			Category cg = categoryDao.findImgByPdiD(id);
			DbUtils.commit();
			return cg;
		} catch (SQLException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Category> selectAll() {
		List<Category> categoryList = null;
		try {
			DbUtils.begin();
			categoryList = categoryDao.selectAll();
			DbUtils.commit();
		} catch (SQLException e) {
			DbUtils.rollbacl();
			e.printStackTrace();
		}
		return categoryList;
	}
}
