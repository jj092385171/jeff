package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.sql.Blob;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.City;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;

@Repository
@Transactional
public class CampDao {
	
	@Autowired
	private SessionFactory factory;

	
	//新增營地
	public Camp AddCamp(Camp camp) {
		Session session = factory.openSession();
		session.save(camp);
		return camp;
	}
	
	//搜尋全部
	public List<Camp> showAll(){
		Session session = factory.openSession();
		Query<Camp> query = session.createQuery("from Camp", Camp.class);
		List<Camp> resultList = query.getResultList();
		
		return resultList;
	}	
	
	//透過campID查詢camp
	public Camp findCampByID(int campID) {
		Session session = factory.openSession();
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null) {
			return camp;
		}
		
		return null;
	}
	
	//更新營地
	public Camp updateByCampID(int campID , String campName, int cityID, String location, Blob campPictures, String description, Set<Tag> tags) {
		Session session = factory.openSession();
		Camp campBean = session.get(Camp.class, campID);
		
		if(campBean != null) {
			campBean.setCampName(campName);
			campBean.setCity(session.get(City.class, cityID));
			campBean.setLocation(location);
			campBean.setCampPictures(campPictures);
			campBean.setDescription(description);
			campBean.setTags(tags);
			
			return campBean;
		}
		
		return null;
	}
	
	//刪除營地
	public boolean deletdByCampID(int campID){
		Session session = factory.openSession();
		Camp camp = session.get(Camp.class, campID);

		if(camp != null) {
			deletdTagsByID(campID);
			deleteSitesbyCampID(campID);
			session.delete(camp);
			return true;
		}
		
		return false;
	}

	//刪除TagOfCamp
	public boolean deletdTagsByID(int campID){
		Session session = factory.openSession();
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null) {
			Set<Tag> tags = camp.getTags();
			Iterator<Tag> it = tags.iterator();
			while (it.hasNext()) {
				Tag tag = (Tag) it.next();
				it.remove();
//					session.delete(tag);
			}
		}
		
		return false;
	}
	
	//刪除SitebyCampID
	public boolean deleteSitesbyCampID(int campID){
		Session session = factory.openSession();
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null) {
			Set<Site> sites = camp.getSites();
			Iterator<Site> it = sites.iterator();
			while (it.hasNext()) {
				Site site = (Site) it.next();
				it.remove();
				session.delete(site);
			}
		}
		
		return false;
	}
	
	
}
