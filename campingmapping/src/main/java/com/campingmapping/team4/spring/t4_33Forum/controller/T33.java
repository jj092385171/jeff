package com.campingmapping.team4.spring.t4_33Forum.controller;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostCommentService;
import com.campingmapping.team4.spring.t4_33Forum.model.service.PostService;

import util.HibernateUtils;

public class T33 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Post post = new Post();
			PostService postService = new PostService();
			
			System.out.println("新增貼文：");
			post.setUserId(2);
			post.setTitle("測試新增貼文");
			post.setContent("測試新增內容");
			
//			List<Post> resultList = postService.selectPost(post);
//			for(Post p : resultList) {
//				System.out.println(p.getPostId());
//				System.out.println(p.getTitle());
//			}
//			post.setPostId(10);
//			post.setUserId(2);

			List<Post> resultList = postService.selectReportPost(post);
			for(Post p : resultList) {
				System.out.println(p.getPostId());
				System.out.println(p.getTitle());
			}

//			Post newPost = postService.insertPostService(post);
//			System.out.print(newPost.getPostId());
//			System.out.println(newPost.getTitle());
			
			PostComment postComment = new PostComment();
//			Post post = new Post();
//			
//			post.setPostId(8);
//			postComment.setPost(post);
			postComment.setPostCommentId(12);
//			postComment.setPostComment("測試檢舉留言");
			
			PostCommentService postCommentService = new PostCommentService();
			
//			Boolean result = postCommentService.hidePostComment(postComment);
//			System.out.println("result:" + result);
//			
//			List<PostComment> resultList = postCommentService.selectReportPostComment(postComment);
//			for(PostComment p : resultList) {
//				System.out.println(p.getPostCommentId());
//				System.out.println(p.getPostComment());
//			}
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			// TODO: handle exception
		} finally {
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
