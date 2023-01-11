package com.campingmapping.team4.spring.t436mall.model.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductCart;

public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {

	
		// 新增一筆購物車資料
		// 依Pdid來增加or減少購物車產品數量
		// 清空購物車、結帳->新增訂單(只歸0，不刪除)
		// 依userID查詢購物車資料
}
