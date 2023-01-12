package com.campingmapping.team4.spring.t4_33Forum.model.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
@Repository
@Transactional
public class PostDao {
	@Autowired
	private SessionFactory factory;
//	private Session session = factory.openSession();
	
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
//	public PostDao(Session session) {
//		this.session = session;
//	}

	// 查所有貼文
	public List<Post> findAllPost() {
		Session session = factory.openSession();
		String hql = "from Post where postHide != ?1 order by releaseDate desc";
		List<Post> resultList = session.createQuery(hql, Post.class).setParameter(1, 1).getResultList();
		session.close();
		return resultList;
	}
	// 查單一貼文
	public Post findPostByPostId(int postId) {
		Session session = factory.openSession();
		Post result = session.get(Post.class, postId);
		session.close();
		return result;
	}
	// 查會員貼文
	public List<Post> findPostByUserId(int userId){
		Session session = factory.openSession();
		String hql = "from Post where userId = ?1 and postHide != ?2 order by releaseDate desc";
		List<Post> resultList = session.createQuery(hql, Post.class).setParameter(1, userId).setParameter(2, 1).getResultList();
		session.close();
		return resultList;
	}
	// 查詢所有被檢舉貼文
	public List<Post> findReportPost(){
		Session session = factory.openSession();
		Post post = new Post();
		post.setPostReport(1);
		post.setPostHide(1);
			
		String hql = "from Post where postReport = ?1 and postHide !=?2 order by releaseDate desc";
		List<Post> resultList = session.createQuery(hql, Post.class).setParameter(1, post.getPostReport()).setParameter(2, post.getPostHide()).getResultList();
		session.close();
		return resultList;
	}
	// 查詢所有隱藏貼文
	public List<Post> findHidePost(){
		Session session = factory.openSession();
		Post post = new Post();
		post.setPostHide(1);
		
		String hql = "from Post where postHide = ?1 order by releaseDate desc";
		List<Post> resultList = session.createQuery(hql, Post.class).setParameter(1, post.getPostHide()).getResultList();
		session.close();
		return resultList;
	}
	
	// 新增貼文
	public void insertPost(Post post) throws ParseException{
		Session session = factory.openSession();
		// 設定userId
		post.setUserId(9);
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
		post.setReleaseDate(utilReleaseDate);
		post.setUserLike(0);
		post.setUserUnlike(0);
		post.setPostReport(0);
		post.setPostHide(0);
		session.save(post);
		session.close();
	}
	
	// 修改貼文
	public void updatePost(Post post) throws ParseException {
		Session session = factory.openSession();
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
		post.setReleaseDate(utilReleaseDate);
		post.setPostReport(0);
		
		Post result = session.get(Post.class, post.getPostId());
		if(result != null) {
			result.setTitle(post.getTitle());
			result.setContent(post.getContent());
			result.setPeople(post.getPeople());
			result.setPrice(post.getPrice());
			result.setCounty(post.getCounty());
			result.setStartDate(post.getStartDate());
			result.setEndDate(post.getEndDate());
			result.setScore(post.getScore());
			result.setReleaseDate(post.getReleaseDate());
			result.setPostReport(post.getPostReport());
		}
		session.update(result);
		session.flush();
		session.close();
	}
	
	// 喜歡貼文
	public void likePost() {
		
	}
	
	// 不喜歡貼文
	public void unlikePost() {
		
	}
	
	// 檢舉貼文
	public Boolean reportPost(int postId){
		Session session = factory.openSession();
		Post post = session.get(Post.class, postId);
		if(post != null && post.getPostReport() == 0 && post.getPostHide() == 0) {
			post.setPostReport(1);
			session.update(post);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	// 取消檢舉貼文
	public Boolean cancelReportPost(int postId){
		Session session = factory.openSession();
		Post post = session.get(Post.class, postId);
		if(post != null && post.getPostReport() == 1 && post.getPostHide() == 0) {
			post.setPostReport(2);
			session.update(post);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	
	// 隱藏貼文
	public Boolean hidePost(int postId) throws ParseException {
		Session session = factory.openSession();
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));		
		Post post = session.get(Post.class, postId);
		if(post != null && post.getPostHide() != 1) {
			post.setReleaseDate(utilReleaseDate);
			post.setPostHide(1);
			session.update(post);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	
	// 取消隱藏貼文
	public Boolean cancelHidePost(int postId) throws ParseException {
		Session session = factory.openSession();
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));			
		Post post = session.get(Post.class, postId);
		if(post != null && post.getPostHide() == 1) {
			post.setReleaseDate(utilReleaseDate);
			post.setPostReport(2);
			post.setPostHide(0);
			session.update(post);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	
}
