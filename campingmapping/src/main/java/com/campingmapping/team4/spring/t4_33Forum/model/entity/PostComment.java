package com.campingmapping.team4.spring.t4_33Forum.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "postComment")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postCommentId")
	private int postCommentId;
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;
	// @ManyToOne
	// @JoinColumn(name="userId")
	// private Member member;
	@Column(name = "postComment")
	private String postComment;
	@Column(name = "postCommentReport")
	private int postCommentReport;
	@Column(name = "postCommentHide")
	private int postCommentHide;

	public PostComment() {
	}

	public int getPostCommentId() {
		return postCommentId;
	}

	public void setPostCommentId(int postCommentId) {
		this.postCommentId = postCommentId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	// public Member getMember() {
	// return member;
	// }
	//
	// public void setMember(Member member) {
	// this.member = member;
	// }

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
