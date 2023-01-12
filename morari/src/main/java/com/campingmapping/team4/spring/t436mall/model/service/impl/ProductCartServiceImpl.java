package com.campingmapping.team4.spring.t436mall.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t436mall.model.dao.repository.ProductCartRepository;
import com.campingmapping.team4.spring.t436mall.model.service.ProductCartService;

@Service
public class ProductCartServiceImpl implements ProductCartService{

	@Autowired
	public ProductCartRepository pDao;
}
