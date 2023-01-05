package com.campingmapping.team4.spring.t4_24Camp.model.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tagID")
	private Integer tagID;

	@Column(name = "tagName")
	private String tagName;

	@ManyToMany(mappedBy = "tags")
	private Set<Camp> camps = new HashSet<>();

	public Tag() {
	}

	public Integer getTagID() {
		return tagID;
	}

	public void setTagID(Integer tagID) {
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
