package com.campingmapping.team4.spring.t424camp.model.entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "site")
public class Site {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "siteID")
	private Integer siteID;

	@Column(name = "siteName")
	private String siteName;

	@Column(name = "sitePictures")
	private Blob sitePictures;

	@Column(name = "totalSites")
	private Integer totalSites;

	@Column(name = "siteMoney")
	private Integer siteMoney;

	@ManyToOne
	@JoinColumn(name = "fk_campID")
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

	public Blob getSitePictures() {
		return sitePictures;
	}

	public void setSitePictures(Blob sitePictures) {
		this.sitePictures = sitePictures;
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
