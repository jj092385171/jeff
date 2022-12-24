package com.campingmapping.team4.spring.t4_24Camp.model.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "camp")
public class Camp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "campID")
	private Integer campID;
	
	@Column(name = "campName")
	private String campName;
	
	@ManyToOne
	@JoinColumn(name = "fk_cityID")
	private City city;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "campPictures")
	private java.sql.Blob campPictures;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "TagOfCamp",
	joinColumns = {@JoinColumn(name = "fk_campID", referencedColumnName = "campID")},
	inverseJoinColumns = {@JoinColumn(name = "fk_tagID", referencedColumnName = "tagID")})
	private Set<Tag> tags = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "camp", cascade = CascadeType.ALL)
	private Set<Site> sites = new HashSet<Site>();
	

	public Camp() {
	}

	
	public Integer getCampID() {
		return campID;
	}

	public void setCampID(Integer campID) {
		this.campID = campID;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public java.sql.Blob getCampPictures() {
		return campPictures;
	}

	public void setCampPictures(java.sql.Blob campPictures) {
		this.campPictures = campPictures;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Tag> getTags() {
		return tags;
	}


	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Site> getSites() {
		return sites;
	}

	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}

	
}
