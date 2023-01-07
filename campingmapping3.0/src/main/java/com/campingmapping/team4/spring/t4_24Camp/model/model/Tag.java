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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tag")
@Component
public class Tag implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tagID")
	private int tagID;
	
	@Column(name = "tagName")
	private String tagName;
	
	@ManyToMany(mappedBy = "tags")
	private Set<Camp> camps = new HashSet<>();
	

	public Tag() {
	}


	public int getTagID() {
		return tagID;
	}

	public void setTagID(int tagID) {
		this.tagID = tagID;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set<Camp> getCamps() {
		return camps;
	}

	public void setCamps(Set<Camp> camps) {
		this.camps = camps;
	}


}
