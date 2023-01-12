package com.campingmapping.team4.spring.t4_33Forum.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_33Forum.model.dao.PostCommentDao;
import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;
@Service
@Transactional
public class PostCommentService {
	@Autowired
	private PostCommentDao postCommentDao;

	// 依貼文查所有留言
	public List<PostComment> findPostCommentByPostId(int postId) {
		return postCommentDao.findPostCommentByPostId(postId);
	}
	
	// 新增留言
	public void insertPostComment(PostComment postComment) {
		postCommentDao.insertPostComment(postComment);
	}
	
	// 隱藏留言
	public void hidePostComment(int postCommentId) {
		postCommentDao.hidePostComment(postCommentId);
	}
}
