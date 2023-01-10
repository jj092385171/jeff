package com.campingmapping.team4.spring.t4_24Camp.model.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "city")
@Component
public class City implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cityID")
	private int cityID;
	
	@Column(name = "cityName")
	private String cityName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "city")
	private Set<Camp>camps = new HashSet<Camp>();

	public City() {
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set<Camp> getCamps() {
		return camps;
	}

	public void setCamps(Set<Camp> camps) {
		this.camps = camps;
	}
	

}
