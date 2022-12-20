package T4_24.Models;


public class SiteBean {
	
	private int siteID;
	private String siteName;
	private java.sql.Blob sitePictures;
	private int totalSites;
	private int siteMoney;
	private int fk_campID;
	

	public SiteBean() {

	}


	public SiteBean(String siteName, java.sql.Blob blob, int totalSites, int siteMoney, int campID) {
		super();
		this.siteName = siteName;
		this.sitePictures = blob;
		this.totalSites = totalSites;
		this.siteMoney = siteMoney;
		this.fk_campID = campID;
	}

	public SiteBean(String siteName, int totalSites, int siteMoney, int campID) {
		super();
		this.siteName = siteName;
		this.totalSites = totalSites;
		this.siteMoney = siteMoney;
		this.fk_campID = campID;
	}
	

	public int getSiteID() {
		return siteID;
	}


	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}


	public String getSiteName() {
		return siteName;
	}


	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	public java.sql.Blob getSitePictures() {
		return sitePictures;
	}


	public void setSitePictures(java.sql.Blob sitePictures) {
		this.sitePictures = sitePictures;
	}


	public int getTotalSites() {
		return totalSites;
	}


	public void setTotalSites(int totalSites) {
		this.totalSites = totalSites;
	}


	public int getSiteMoney() {
		return siteMoney;
	}


	public void setSiteMoney(int siteMoney) {
		this.siteMoney = siteMoney;
	}


	public int getCampID() {
		return fk_campID;
	}


	public void setCampID(int campID) {
		this.fk_campID = campID;
	}



	

}
