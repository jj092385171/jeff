package com.campingmapping.team4.spring.t436mall.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t436mall.model.dao.repository.ProductCartRepository;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductCart;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductCartVo;
import com.campingmapping.team4.spring.t436mall.model.service.ProductCartService;

@Service
@Transactional
public class ProductCartServiceImpl implements ProductCartService {

	@Autowired
	public ProductCartRepository pcDao;
	
	// 依userid新增一筆購物車資料
	@Override
	public ProductCart create(ProductCart productcart) {
		return pcDao.save(productcart);
	}
	// 依cartid來增加or減少購物車產品數量
	@Override
	public ProductCart updataById(ProductCart productcart) {
//		productcart.setUserprofiles(userDao.findById(productcart.getUserprofiles()).get());
		return pcDao.save(productcart);
		
	}
	// 依id刪除購物車
	@Override
	public void deleteById(Integer id) {
		pcDao.deleteById(id);
	}
	// 依userid清空購物車、或結帳
	@Override
	public void deleteAllByUserId(Integer userid) {
		pcDao.deleteAllByUserid(userid);
	}
	// 依userID查詢購物車資料
	@Override
	public List<ProductCartVo> selectAllByUserId(Integer userid) {
		return pcDao.findByUserid(userid);
	}
	// 查詢購物車所有資料(後台)
	@Override
	public List<ProductCartVo> selectAllVo() {
		return pcDao.findAllVo();
	}

}
