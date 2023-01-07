package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;


@Repository
@Transactional
public class SiteDao {
	
	@Autowired
	private SessionFactory factory;

	
	//新增
	public Integer AddCamp(Site site) {
		Session session = factory.openSession();
		
		Serializable siteID = null;
		if(site != null) {
			siteID = session.save(site);
		}
		session.close();
		return (Integer)siteID;
	}
	
	//透過campID查site
	public Set<Site> findSitesByCampID(int campID) {
		Session session = factory.openSession();
		Camp camp = session.get(Camp.class, campID);
		
		Set<Site> sites = camp.getSites();
		
		session.close();
		return sites;
	}
	
	//透過siteID查詢site
	public Site findSiteByID(int siteID) {
		Session session = factory.openSession();
		Site site = session.get(Site.class, siteID);
		
		session.close();
		return site;
	}
	
	//更新營區位
	public Site updateBySiteID(int siteID, String siteName, String sitePicturesPath, int totalSites, int siteMoney) {
		Session session = factory.openSession();
		Site site = session.get(Site.class, siteID);
		
		if(site != null) {
			site.setSiteName(siteName);
			site.setSitePicturesPath(sitePicturesPath);
			site.setTotalSites(totalSites);
			site.setSiteMoney(siteMoney);
			
			session.flush();
	    }
		session.close();
		return site;
    }
	
	//刪除營區地
	public boolean deletdBySiteID(int siteID){
		Session session = factory.openSession();
		Site site = session.get(Site.class, siteID);
			
		if(site != null) {
			session.delete(site);
			
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	
}