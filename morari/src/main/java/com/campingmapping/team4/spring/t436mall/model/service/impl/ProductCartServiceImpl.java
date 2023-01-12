package com.campingmapping.team4.spring.t436mall.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t436mall.model.dao.repository.ProductCartRepository;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductCart;
import com.campingmapping.team4.spring.t436mall.model.service.ProductCartService;

@Service
@Transactional
public class ProductCartServiceImpl implements ProductCartService {

	@Autowired
	public ProductCartRepository pDao;

	// 依userid新增一筆購物車資料
	@Override
	public ProductCart create(ProductCart productcart) {
		return pDao.save(productcart);
	}
	// 依cartid來增加or減少購物車產品數量
	@Override
	public ProductCart updataById(ProductCart productcart) {
		return pDao.save(productcart);
	}
	// 清空購物車
	@Override
	public void deleteByUserId(int id) {
		pDao.deleteById(id);
	}
	// 結帳->新增訂單
	@Override
	public void checkout(int id) {
		// 須先加上建立訂單
		pDao.deleteById(id);
	}
	// 依userID查詢購物車資料
	@Override
	public List<ProductCart> selectAllByUserId(Integer userid) {
		return pDao.findByUserID(userid);
	}
	// 查詢購物車所有資料(後台)
	@Override
	public List<ProductCart> selectAll() {
		return pDao.findAll();
	}

}
