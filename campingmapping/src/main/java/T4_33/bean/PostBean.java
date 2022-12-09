package T4_33.bean;

import java.io.InputStream;
import java.util.Date;

public class PostBean {
	
	private int postId;
	private int userId;
	private String title;
	private String content;
	private InputStream picture; // 照片格式須確認
	private int people;
	private int price;
	private String county;
	private Date startDate;
	private Date endDate;
	private int score;
	private Date releaseDate;
	private int userLike;
	private int userUnlike;
	private int postReport;
	private int postHide;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
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

	public InputStream getPicture() {
		return picture;
	}

	public void setPicture(InputStream picture) {
		this.picture = picture;
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
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
	
}
