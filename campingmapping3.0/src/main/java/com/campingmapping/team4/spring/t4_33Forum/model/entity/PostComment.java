package com.campingmapping.team4.spring.t4_33Forum.model.entity;

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
@Table(name="postComment")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="postCommentId")
	private int postCommentId;
	@ManyToOne
	@JoinColumn(name="postId")
	private Post post;
//	@ManyToOne
//	@JoinColumn(name="userId")
//	private Member member;
	@Column(name="postComment")
	private String postComment;
	@Column(name="postCommentReport")
	private int postCommentReport;
	@Column(name="postCommentHide")
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

//	public Member getMember() {
//		return member;
//	}
//
//	public void setMember(Member member) {
//		this.member = member;
//	}

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
