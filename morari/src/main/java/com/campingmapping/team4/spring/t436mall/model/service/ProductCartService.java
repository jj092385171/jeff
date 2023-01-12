package com.campingmapping.team4.spring.t436mall.model.service;

import java.util.List;

import com.campingmapping.team4.spring.t436mall.model.entity.ProductCart;

public interface ProductCartService {

	// 依userid新增一筆購物車資料
	public ProductCart create(ProductCart productcart);
	// 依cartid來增加or減少購物車產品數量
	public ProductCart updataById(ProductCart productcart);
	// 清空購物車
	public void deleteByUserId(int id);
	// 結帳->新增訂單
	public void checkout(int id);
	// 依userID查詢購物車資料
	public List<ProductCart> selectAllByUserId(Integer userid);
	// 查詢購物車所有資料(後台)
	public List<ProductCart> selectAll();
}
