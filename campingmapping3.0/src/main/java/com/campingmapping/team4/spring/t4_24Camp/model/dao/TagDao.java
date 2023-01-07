package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;


@Repository
@Transactional
public class TagDao {
	
	@Autowired
	private SessionFactory factory;
	
	
	//ID搜尋標籤
	public Tag findByID(int tadID){
		Session session = factory.openSession();
		
		Tag tag = session.get(Tag.class, tadID);
		
		session.close();
		return tag;
	}	
	
	//搜尋全部標籤
	public List<Tag> showAll(){
		Session session = factory.openSession();
		Query<Tag> query = session.createQuery("from Tag", Tag.class);
		List<Tag> resultList = query.getResultList();
		
		session.close();
		return resultList;
	}	
	

}
