package com.campingmapping.team4.spring.t433forum.model.entity;

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
@Table(name = "postComment")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postCommentId")
	private Integer postCommentId;
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;
	// @ManyToOne
	// @JoinColumn(name="userId")
	// private Member member;
	@Column(name = "postComment")
	private String postComment;
	@Column(name = "postCommentReport")
	private Integer postCommentReport;
	@Column(name = "postCommentHide")
	private Integer postCommentHide;

}
