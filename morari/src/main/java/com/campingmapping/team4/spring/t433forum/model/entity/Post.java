package com.campingmapping.team4.spring.t433forum.model.entity;

import java.util.Date;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postid")
	private Integer postid;

	@ManyToOne
	@JoinColumn(name = "uid")
	@JsonIgnoreProperties("post")
	private UserProfiles userprofiles;

	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "people")
	private Integer people;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "county")
	private String county;
	
	@Column(name = "startdate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date startdate;
	
	@Column(name = "enddate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date enddate;
	
	@Column(name = "score")
	private Integer score;
	
	@Column(name = "releasedate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date releasedate;
	
	@Column(name = "userlike")
	private Integer userlike;
	
	@Column(name = "userunlike")
	private Integer userunlike;
	
	@Column(name = "postreport")
	private Integer postreport;
	
	@Column(name = "posthide")
	private Integer posthide;

}
