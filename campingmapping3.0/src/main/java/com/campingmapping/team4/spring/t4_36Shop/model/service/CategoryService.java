package com.campingmapping.team4.spring.t4_36Shop.model.service;

import java.sql.SQLException;
import java.util.List;

import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;

public interface CategoryService {

	void create(Category category) throws SQLException;

	void delete(int id) throws SQLException;

	void update(Category category) throws SQLException;

	Category select(int id) throws SQLException;

//    Category findImgByPdiD(int id);

	List<Category> selectAll() throws SQLException;
}
