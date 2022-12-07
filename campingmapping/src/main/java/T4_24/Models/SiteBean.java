package T4_24.Models;

import java.util.Date;

import com.mysql.cj.jdbc.Blob;

public class SiteBean {
	
	private String siteName;
	private Blob sitePictures;
	private int totalSites;
	private int siteMoney;
	private int campID;
	
	
	public SiteBean() {

	}


	public SiteBean(String siteName, Blob sitePictures, int totalSites, int siteMoney, int campID) {
		super();
		this.siteName = siteName;
		this.sitePictures = sitePictures;
		this.totalSites = totalSites;
		this.siteMoney = siteMoney;
		this.campID = campID;
	}


	public String getSiteName() {
		return siteName;
	}


	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	public Blob getSitePictures() {
		return sitePictures;
	}


	public void setSitePictures(Blob sitePictures) {
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
		return campID;
	}


	public void setCampID(int campID) {
		this.campID = campID;
	}



	

}
