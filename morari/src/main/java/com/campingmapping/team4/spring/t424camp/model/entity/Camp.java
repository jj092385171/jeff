package com.campingmapping.team4.spring.t424camp.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "camp")
@Component
public class Camp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAMPID")
	private Integer campID;

	@Column(name = "CAMPNAME")
	private String campName;

//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "FKCITYID")
	private City city;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "CAMPPICTURESPATH")
	private String campPicturesPath;

	@Column(name = "DESCRIPTION")
	private String description;

//	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tagofcamp", joinColumns = {
			@JoinColumn(name = "FKCAMPID", referencedColumnName = "CAMPID") }, inverseJoinColumns = {
					@JoinColumn(name = "FKTAGID", referencedColumnName = "TAGID") })
	private Set<Tag> tags = new HashSet<>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "camp")
	private Set<Site> sites = new HashSet<Site>();

	public Camp() {
	}

	public Camp(Integer campID, String campName, City city, String location, String campPicturesPath,
			String description, Set<Tag> tags) {
		super();
		this.campID = campID;
		this.campName = campName;
		this.city = city;
		this.location = location;
		this.campPicturesPath = campPicturesPath;
		this.description = description;
		this.tags = tags;
	}

	public Camp(String campName, City city, String location, String campPicturesPath, String description,
			Set<Tag> tags) {
		super();
		this.campName = campName;
		this.city = city;
		this.location = location;
		this.campPicturesPath = campPicturesPath;
		this.description = description;
		this.tags = tags;
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
