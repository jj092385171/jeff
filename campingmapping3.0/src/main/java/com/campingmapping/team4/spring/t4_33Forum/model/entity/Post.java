package com.campingmapping.team4.spring.t4_33Forum.model.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="postId")
	private int postId;
//	@ManyToOne
//	@JoinColumn(name="userId")
//	private Member member;
	
	private int userId;
	
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="people")
	private int people;
	@Column(name="price")
	private int price;
	@Column(name="county")
	private String county;
	@Column(name="startDate")
	private Date startDate;
	@Column(name="endDate")
	private Date endDate;
	@Column(name="score")
	private int score;
	@Column(name="releaseDate")
	private Timestamp releaseDate;
	@Column(name="userLike")
	private int userLike;
	@Column(name="userUnlike")
	private int userUnlike;
	@Column(name="postReport")
	private int postReport;
	@Column(name="postHide")
	private int postHide;
	
	public Post() {
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

//	public Member getMember() {
//		return member;
//	}
//
//	public void setMember(Member member) {
//		this.member = member;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timestamp getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getUserLike() {
		return userLike;
	}

	public void setUserLike(int userLike) {
		this.userLike = userLike;
	}

	public int getUserUnlike() {
		return userUnlike;
	}

	public void setUserUnlike(int userUnlike) {
		this.userUnlike = userUnlike;
	}

	public int getPostReport() {
		return postReport;
	}

	public void setPostReport(int postReport) {
		this.postReport = postReport;
	}

	public int getPostHide() {
		return postHide;
	}

	public void setPostHide(int postHide) {
		this.postHide = postHide;
	}

	// test
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
