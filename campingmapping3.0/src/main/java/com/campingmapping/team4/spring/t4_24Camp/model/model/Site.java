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
	private Integer siteID;
	
	@Column(name = "siteName")
	private String siteName;
	
	@Column(name = "sitePicturesPath")
	private String sitePicturesPath;
	
	@Column(name = "totalSites")
	private Integer totalSites;
	
	@Column(name = "siteMoney")
	private Integer siteMoney;
	
	@ManyToOne
	@JoinColumn(name = "fkCampID")
	private Camp camp;
	
	
	public Site() {
	}

	
	public Integer getSiteID() {
		return siteID;
	}

	public void setSiteID(Integer siteID) {
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

	public Integer getTotalSites() {
		return totalSites;
	}

	public void setTotalSites(Integer totalSites) {
		this.totalSites = totalSites;
	}

	public Integer getSiteMoney() {
		return siteMoney;
	}

	public void setSiteMoney(Integer siteMoney) {
		this.siteMoney = siteMoney;
	}

	public Camp getCamp() {
		return camp;
	}

	public void setCamp(Camp camp) {
		this.camp = camp;
	}


}
