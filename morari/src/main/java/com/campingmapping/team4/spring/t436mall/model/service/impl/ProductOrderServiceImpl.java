package com.campingmapping.team4.spring.t436mall.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t436mall.model.dao.repository.ProductOrderRepository;
import com.campingmapping.team4.spring.t436mall.model.service.ProductOrderService;

@Service
public class ProductOrderServiceImpl implements ProductOrderService{

	@Autowired
	public ProductOrderRepository pDao;
}
