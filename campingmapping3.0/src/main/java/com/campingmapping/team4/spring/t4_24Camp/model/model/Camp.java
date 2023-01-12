package com.campingmapping.team4.spring.t4_24Camp.model.model;

import java.util.HashSet;
import java.util.Set;

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

import org.springframework.stereotype.Component;


@Entity
@Table(name = "camp")
@Component
public class Camp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "campID")
	private Integer campID;
	
	@Column(name = "campName")
	private String campName;
	
	@ManyToOne
	@JoinColumn(name = "fkCityID")
	private City city;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "campPicturesPath")
	private String campPicturesPath;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tagOfCamp",
	joinColumns = {@JoinColumn(name = "fkCampID", referencedColumnName = "campID")},
	inverseJoinColumns = { @JoinColumn(name = "fkTagID", referencedColumnName = "tagID")})
	private Set<Tag> tags = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "camp")
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

	public String getCampPicturesPath() {
		return campPicturesPath;
	}


	public void setCampPicturesPath(String campPicturesPath) {
		this.campPicturesPath = campPicturesPath;
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
