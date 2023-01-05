package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;



public class TagDao {
	
	private Session session;

	public TagDao(Session session) {
		this.session = session;
	}
		
	//搜尋全部標籤
	public List<Tag> showAll(){
		Query<Tag> query = session.createQuery("from Tag", Tag.class);
		List<Tag> resultList = query.getResultList();
		
		return resultList;
	}	
	

}
