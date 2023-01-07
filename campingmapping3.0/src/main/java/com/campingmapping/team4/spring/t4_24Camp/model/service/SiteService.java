package com.campingmapping.team4.spring.t4_24Camp.model.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_24Camp.model.dao.SiteDao;
import com.campingmapping.team4.spring.t4_24Camp.model.model.Site;

@Service
@Transactional
public class SiteService {

	@Autowired
	private SiteDao siteDao;
	
	
	//新增
	public Integer AddCamp(Site site) {
		return siteDao.AddCamp(site);
	}
	
	//透過campID查site
	public Set<Site> findSitesByCampID(int campID) {
		return siteDao.findSitesByCampID(campID);
	}
	
	//透過siteID查詢site
	public Site findSiteByID(int siteID) {
		return siteDao.findSiteByID(siteID);
	}
	
	//更新營區位
	public Site updateBySiteID(int siteID, String siteName, String sitePicturesPath, int totalSites, int siteMoney) {
		return siteDao.updateBySiteID(siteID, siteName, sitePicturesPath, totalSites, siteMoney);
	}
	
	//刪除營區地
	public boolean deletdBySiteID(int siteID){
		return siteDao.deletdBySiteID(siteID);
	}
	
}
