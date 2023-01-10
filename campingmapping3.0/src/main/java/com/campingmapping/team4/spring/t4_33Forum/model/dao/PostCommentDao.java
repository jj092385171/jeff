package com.campingmapping.team4.spring.t4_33Forum.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;

@Repository
@Transactional
public class PostCommentDao {
	@Autowired
	private SessionFactory factory;
	
	// 依貼文查所有留言
	public List<PostComment> findPostCommentByPostId(int postId) {
		Session session = factory.openSession();
		String hql = "from PostComment where postId = ?1 and postCommentHide != 1";
		List<PostComment> resultList = session.createQuery(hql, PostComment.class).setParameter(1, postId).getResultList();
		session.close();
		return resultList;
	}
	
	// 新增留言
	public void insertPostComment(PostComment postComment) {
		Session session = factory.openSession();
		// 設定userId
		postComment.setUserId(9);
		
		postComment.setPostCommentReport(0);
		postComment.setPostCommentHide(0);
		session.save(postComment);
		session.close();
	}
	
	// 隱藏留言
	public void hidePostComment(int postCommentId) {
		Session session = factory.openSession();
		PostComment postComment = session.get(PostComment.class, postCommentId);
		if(postComment != null) {
			postComment.setPostCommentHide(1);
			session.update(postComment);
			session.flush();
			session.close();
		}
	}
}
