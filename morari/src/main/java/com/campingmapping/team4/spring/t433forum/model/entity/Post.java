package com.campingmapping.team4.spring.t433forum.model.entity;

import java.sql.Timestamp;
import java.util.Date;

import com.campingmapping.team4.spring.t401member.model.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postId")
	private Integer postId;

	@ManyToOne
	@JoinColumn(name = "uid")
	private User user;

	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "people")
	private Integer people;
	@Column(name = "price")
	private Integer price;
	@Column(name = "county")
	private String county;
	@Column(name = "startDate")
	private Date startDate;
	@Column(name = "endDate")
	private Date endDate;
	@Column(name = "score")
	private Integer score;
	@Column(name = "releaseDate")
	private Timestamp releaseDate;
	@Column(name = "userLike")
	private Integer userLike;
	@Column(name = "userUnlike")
	private Integer userUnlike;
	@Column(name = "postReport")
	private Integer postReport;
	@Column(name = "postHide")
	private Integer postHide;

}
