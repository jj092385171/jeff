package T4_33.bean;

import java.io.InputStream;
import java.util.Date;

public class DiscussionBean {
	// 會員
	private int userId;

	// 貼文
	private int postId;
	private String title;
	private String content;
	private InputStream picture; // 照片格式須確認
	private int people;
	private int price;
	private String county;
	private Date startDate;
	private Date endDate;
	private int score;
	private String releaseDate;
	private int userLike;
	private int userUnlike;
	private int postReport;
	private int postHide;

	// 留言
	private int postCommentId;
	private String postComment;
	private int postCommentReport;
	private int postCommentHide;

	// 會員
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// 貼文
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
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

	// 留言
	public int getPostCommentId() {
		return postCommentId;
	}

	public void setPostCommentId(int postCommentId) {
		this.postCommentId = postCommentId;
	}

	public String getPostComment() {
		return postComment;
	}

	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}

	public int getPostCommentReport() {
		return postCommentReport;
	}

	public void setPostCommentReport(int postCommentReport) {
		this.postCommentReport = postCommentReport;
	}

	public int getPostCommentHide() {
		return postCommentHide;
	}

	public void setPostCommentHide(int postCommentHide) {
		this.postCommentHide = postCommentHide;
	}
	
}
