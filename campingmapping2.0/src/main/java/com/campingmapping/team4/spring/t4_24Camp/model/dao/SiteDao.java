package T4_24.dao;

import java.sql.Blob;
import java.util.Set;

import org.hibernate.Session;

import T4_24.model.Camp;
import T4_24.model.Site;


public class SiteDao {
	
private Session session;
	
	public SiteDao(Session session){
		this.session = session;
	}

	
	//新增
	public Site AddCamp(Site site) {
	
			session.save(site);
			return site;
	}
	
	//透過campID查site
	public Set<Site> findSitesByCampID(Integer campID) {
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
	public Site findSiteByID(Integer siteID) {
		Site site = session.get(Site.class, siteID);
		
		if(site != null) {
			return site;
		}
		
		return null;
	}
	
	//更新營區位
	public Site updateBySiteID(Integer siteID, String siteName, Blob sitePictures, Integer totalSites, Integer siteMoney) {
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
	
	

	
}