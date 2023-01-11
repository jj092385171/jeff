package com.campingmapping.team4.spring.t436mall.model.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrder;

public interface ProductOrderRepository	extends	JpaRepository<ProductOrder, Integer> {

		// 根據購物車新增一筆訂單
		// 依userID來修改單筆產品(只有後臺能使用)
		// 依orderID來搜尋單筆訂單
		// 依userID來搜尋所有訂單
		// 搜尋所有訂單(只有後臺能使用)
		// 修改訂單出貨地址、收件人、手機號(只有後臺能使用)
	
}
