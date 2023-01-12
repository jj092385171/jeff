package com.campingmapping.team4.spring.t4_36Shop.model.service;

import java.sql.SQLException;
import java.util.List;

import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;

public interface CategoryService {

	Category create(Category category) throws SQLException;

	Boolean delete(int id) throws SQLException;

	Category update(Category category) throws SQLException, Exception;

	Category select(int id) throws SQLException;

	List<Category> selectAll() throws SQLException;
}
