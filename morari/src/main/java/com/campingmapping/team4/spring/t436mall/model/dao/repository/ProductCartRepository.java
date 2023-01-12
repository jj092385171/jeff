package com.campingmapping.team4.spring.t436mall.model.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductCart;

public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {

	// 依userid新增一筆購物車資料
	// 依cartid來增加or減少購物車產品數量
	// 清空購物車
	// 結帳->新增訂單
	// 依userID查詢購物車資料
	@Query(value = "from productcart where userid = ?1")
	List<ProductCart> findByUserID(Integer userid);
	// 查詢購物車所有資料(後台)

}
