package com.campingmapping.team4.spring.t433forum.model.entity;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
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
@Table(name = "postcomment")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
	@Column(name = "postCommentId")
	private Integer postCommentId;
=======
	@Column(name = "postcommentId")
	private Integer postcommentId;
	
>>>>>>> origin/33
	@ManyToOne
	@JoinColumn(name = "postid")
	private Post post;
	// @ManyToOne
	// @JoinColumn(name="userId")
	// private Member member;
<<<<<<< HEAD
	@Column(name = "postComment")
	private String postComment;
	@Column(name = "postCommentReport")
	private Integer postCommentReport;
	@Column(name = "postCommentHide")
	private Integer postCommentHide;
=======
	@ManyToOne
	@JoinColumn(name = "uid")
	@JsonIgnoreProperties("post")
	private UserProfiles userprofiles;
	
	@Column(name = "postcomment")
	private String postcomment;
	@Column(name = "postcommentreport")
	private Integer postcommentreport;
	@Column(name = "postcommenthide")
	private Integer postcommenthide;
>>>>>>> origin/33

}
