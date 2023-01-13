package com.campingmapping.team4.spring.t4_24Camp.model.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "site")
@Component
public class Site implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "siteID")
	private int siteID;
	
	@Column(name = "siteName")
	private String siteName;
	
	@Column(name = "sitePicturesPath")
	private String sitePicturesPath;
	
	@Column(name = "totalSites")
	private int totalSites;
	
	@Column(name = "siteMoney")
	private int siteMoney;
	
	@ManyToOne
	@JoinColumn(name = "fkCampID")
	private Camp camp;
	
	
	public Site() {
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

	public String getSitePicturesPath() {
		return sitePicturesPath;
	}

	public void setSitePicturesPath(String sitePicturesPath) {
		this.sitePicturesPath = sitePicturesPath;
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

	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}


}
