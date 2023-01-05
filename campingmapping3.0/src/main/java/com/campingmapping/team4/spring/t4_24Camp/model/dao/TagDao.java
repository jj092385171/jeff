package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;



public class TagDao {
	
	@Autowired
	private SessionFactory factory;
	
		
	//搜尋全部標籤
	public List<Tag> showAll(){
		Session session = factory.openSession();
		Query<Tag> query = session.createQuery("from Tag", Tag.class);
		List<Tag> resultList = query.getResultList();
		
		return resultList;
	}	
	

}
