package com.campingmapping.team4.spring.t4_24Camp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.TagDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;

@Service
@Transactional
public class TagService {
	
	@Autowired
	private TagDao tagDao;
	
	
	//搜尋全部標籤
	public List<Tag> showAll(){
		return tagDao.showAll();
	}
	
}
