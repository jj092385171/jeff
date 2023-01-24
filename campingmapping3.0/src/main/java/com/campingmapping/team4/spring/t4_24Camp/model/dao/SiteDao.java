package com.campingmapping.team4.spring.t4_24Camp.model.dao;

import java.sql.Blob;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;



public class SiteDao {
	
	@Autowired
	private SessionFactory factory;

	
	//新增
	public Site AddCamp(Site site) {
		Session session = factory.openSession();
		session.save(site);
		return site;
	}
	
	//透過campID查site
	public Set<Site> findSitesByCampID(int campID) {
		Session session = factory.openSession();
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null ) {
			Set<Site> sites = camp.getSites();
				if(sites != null) {
					return sites;
				}
		}
		
		return null;
	}
	
	//透過siteID查詢site
	public Site findSiteByID(int siteID) {
		Session session = factory.openSession();
		Site site = session.get(Site.class, siteID);
		
		if(site != null) {
			return site;
		}
		
		return null;
	}
	
	//更新營區位
	public Site updateBySiteID(int siteID, String siteName, Blob sitePictures, int totalSites, int siteMoney) {
		Session session = factory.openSession();
		Site site = session.get(Site.class, siteID);
		
		if(site != null) {
			site.setSiteName(siteName);
			site.setSitePictures(sitePictures);
			site.setTotalSites(totalSites);
			site.setSiteMoney(siteMoney);
			
			return site;
	    }
		
		return  null;
    }
	
	//刪除營區地
	public boolean deletdBySiteID(int siteID){
		Session session = factory.openSession();
		Site site = session.get(Site.class, siteID);
			
		if(site != null) {
			session.delete(site);
			return true;
		}
		
		return false;
	}

	
}