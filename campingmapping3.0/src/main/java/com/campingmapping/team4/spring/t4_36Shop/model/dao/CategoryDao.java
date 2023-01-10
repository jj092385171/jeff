package com.campingmapping.team4.spring.t4_36Shop.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;

public interface CategoryDao {

	// 新增一筆資料
	Category insert(Category category) throws SQLException;
	// 依Pd_id來刪除單筆資料
	Boolean deleteByPd_id(int id) throws SQLException;
	// 依Pd_id來修改單筆資料
	Category updateByPdid(Category category) throws SQLException;
	// 依Pd_id來查詢單筆資料
	Category selectByPdid(int Pdid) throws SQLException;
	//顯示所有資料
	List<Category> selectAll() throws SQLException;

}
