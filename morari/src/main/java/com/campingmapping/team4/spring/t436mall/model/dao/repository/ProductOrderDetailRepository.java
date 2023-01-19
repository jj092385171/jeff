package com.campingmapping.team4.spring.t436mall.model.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrderDetail;

public interface ProductOrderDetailRepository extends JpaRepository<ProductOrderDetail, Integer> {

	// 根據產品編號新增一筆訂單詳情
	// 搜尋所有訂單詳情
	// 根據訂單編號搜尋所有訂單詳情
	public List<ProductOrderDetail> findByPdorderid(String pdorderid);

}
