package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.io.Serializable;
import java.util.HashSet;
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

	// 新增營地
	public int addCamp(String campName, int cityID, String location, String campPicturesPath, String description,
			int[] tagIDs) {
		Session session = factory.openSession();

		Set<Tag> tags = new HashSet<Tag>();
		for (int tagID : tagIDs) {
			Tag tag = session.get(Tag.class, tagID);
			tags.add(tag);
		}

		Camp camp = new Camp();
		camp.setCampName(campName);
		camp.setCity(session.get(City.class, cityID));
		camp.setLocation(location);
		camp.setCampPicturesPath(campPicturesPath);
		camp.setDescription(description);
		camp.setTags(tags);

		Serializable campID = session.save(camp);
		session.flush();

		session.close();
		return (Integer) campID;
	}

	// 搜尋全部
	public List<Camp> showAll() {
		Session session = factory.openSession();
		Query<Camp> query = session.createQuery("from Camp", Camp.class);
		List<Camp> resultList = query.getResultList();

		session.close();
		return resultList;
	}

	// 透過campID查詢camp
	public Camp findCampByID(int campID) {
		Session session = factory.openSession();
		Camp camp = session.get(Camp.class, campID);

		session.close();
		return camp;
	}

	// 更新營地
	public Camp updateByCampID(int campID, String campName, int cityID, String location, String campPicturesPath,
			String description, int[] tagIDs) {
		Session session = factory.openSession();
		
		Set<Tag> tags = new HashSet<Tag>();
		for (int tagID : tagIDs) {
			Tag tag = session.get(Tag.class, tagID);
			tags.add(tag);
		}
		
		Camp campBean = session.get(Camp.class, campID);

		if (campBean != null) {
			campBean.setCampName(campName);
			campBean.setCity(session.get(City.class, cityID));
			campBean.setLocation(location);
			campBean.setCampPicturesPath(campPicturesPath);
			campBean.setDescription(description);
			campBean.setTags(tags);

			session.flush();
		}

		session.close();
		return campBean;
	}

	// 刪除營地
	public boolean deletdByCampID(int campID){
		Session session = factory.openSession();
		Camp camp = session.get(Camp.class, campID);
		
		camp.setCity(null);
		
		if(camp != null) {
			//刪除TagOfCamp
			Set<Tag> tags = camp.getTags();
			if(tags.size() != 0) {
				Iterator<Tag> it1 = tags.iterator();
				while (it1.hasNext()) {
					Tag tag = it1.next();
					it1.remove();
				}
			}
			
			//刪除SiteOfCamp
			Set<Site> sites = camp.getSites();
			if(sites.size() != 0) {
				for (Site site : sites) {
					site.setCamp(null);
					session.delete(site);
					session.flush();
				}
			}
			
			session.delete(camp);
			session.flush();
			
			session.close();
			return true;
		}
		
		session.close();
		return false;
	}
	

}
