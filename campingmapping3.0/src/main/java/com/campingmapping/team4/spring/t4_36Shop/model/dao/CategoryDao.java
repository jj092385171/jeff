package com.campingmapping.team4.spring.t4_36Shop.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;

public interface CategoryDao {

	// 新增一筆記錄
	Category insert(Category category) throws SQLException;

	// 依Pd_id來刪除單筆記錄
	Boolean deleteByPd_id(int id) throws SQLException;

	Category updateByPdid(Category category) throws SQLException;

	Category selectByPdid(int Pdid) throws SQLException;

	List<Category> selectAll() throws SQLException;

}
