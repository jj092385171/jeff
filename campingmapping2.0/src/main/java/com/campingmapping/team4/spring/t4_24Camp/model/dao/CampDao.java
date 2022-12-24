package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.City;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Tag;


public class CampDao {
	
	private Session session;
	
	public CampDao(Session session){
		this.session = session;
	}

	
	//新增營地
	public Camp AddCamp(Camp camp) {
	
			session.save(camp);
			return camp;
	}
	
	//搜尋全部
	public List<Camp> showAll(){
		Query<Camp> query = session.createQuery("from Camp", Camp.class);
		List<Camp> resultList = query.getResultList();
		
		return resultList;
	}	
	
	//透過campID查詢camp
	public Camp findCampByID(int campID) {
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null) {
			return camp;
		}
		
		return null;
	}
	
	//更新營地
	public Camp updateByCampID(int campID , String campName, int cityID, String location, Blob campPictures, String description, Set<Tag> tags) {
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
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null) {
			deletdTagsByID(campID);
			SiteDao siteDao = new SiteDao(session);
			Set<Site> sites = siteDao.findSitesByCampID(campID);
			session.delete(sites);
			session.delete(camp);
			return true;
		}
		
		return false;
	}
	
	//刪除TagOfCamp
	public boolean deletdTagsByID(int campID){
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null) {
			session.delete(camp.getTags());
			return true;
		}
		
		return false;
	}
	
	
}
