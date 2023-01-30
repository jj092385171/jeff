package com.campingmapping.team4.spring.t436mall.model.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t436mall.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


	// 新增一筆產品
	// 依Pdid來刪除單筆產品
	// 依Pdid來修改單筆產品
	// 依Pdid來搜尋單筆產品
	// 搜尋所有產品
	// 購買產品修改庫存
}
