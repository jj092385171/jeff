package com.campingmapping.team4.spring.t4_33Forum.model.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_33Forum.controller.newPostServlet;
import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
@Repository
@Transactional
public class PostDao {
	@Autowired
	private SessionFactory factory;
	private Session session = factory.openSession();
	
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
//	public PostDao(Session session) {
//		this.session = session;
//	}

	// 查所有貼文
	public List<Post> selectAllPost() {
		String hql = "from Post where postHide != ?1 order by releaseDate desc";
		Post post = new Post();
		post.setPostHide(1);
		List<Post> resultList = this.session.createQuery(hql, Post.class).setParameter(1, post.getPostHide()).getResultList();
		session.close();
		return resultList;
	}
	// 查單一貼文
	public Post selectSinglePost(Post post) {
		String hql = "from Post where postId = ?1";
		Post singleResult = this.session.createQuery(hql, Post.class).setParameter(1, post.getPostId()).getSingleResult();
		return singleResult;
	}
	// 查會員貼文
	
	
	// 新增貼文
	public void insertPost(Post post)throws SQLException, ParseException{
		// 設定userId
		post.setUserId(9);
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
		post.setReleaseDate(new Date(utilReleaseDate.getTime()));
		post.setUserLike(0);
		post.setUserUnlike(0);
		post.setPostReport(0);
		post.setPostHide(0);
		this.session.save(post);
	}
	
	// 修改貼文
	public void updatePost(Post post) throws SQLException, ParseException {
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
		post.setReleaseDate(new Date(utilReleaseDate.getTime()));
		post.setPostReport(0);
		
		Post result = this.session.get(Post.class, post.getPostId());
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
	}
	
	// 喜歡貼文
	
	
	// 不喜歡貼文
	
	
	// 檢舉貼文
	public Boolean reportPost(Post post) throws SQLException {
		post.setPostReport(1);
		Post result = this.session.get(Post.class, post.getPostId());
		if(result != null && result.getPostReport() == 0) {
			result.setPostReport(post.getPostReport());
			return true;
		}
		return false;
	}
	
	// 查詢所有被檢舉貼文
	public List<Post> selectReportPost() throws SQLException {
		Post post = new Post();
		post.setPostReport(1);
		post.setPostHide(1);
		
		String hql = "from Post where postReport = ?1 and postHide !=?2 order by releaseDate desc";
		List<Post> resultList = this.session.createQuery(hql, Post.class).setParameter(1, post.getPostReport()).setParameter(2, post.getPostHide()).getResultList();
		return resultList;
	}
	
	// 取消檢舉貼文
	public Boolean cancelReportPost(Post post) throws SQLException {
		post.setPostReport(2);
		Post result = this.session.get(Post.class, post.getPostId());
		if(result != null) {
			result.setPostReport(post.getPostReport());
			return true;
		}
		return false;
	}
	
	// 變更是否隱藏貼文
	public void changeHidePost(Post post) throws SQLException, ParseException {
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
		post.setReleaseDate(new Date(utilReleaseDate.getTime()));
		
		Post result = this.session.get(Post.class, post.getPostId());
		if(result != null) {
			result.setReleaseDate(post.getReleaseDate());
			result.setPostHide(post.getPostHide());
		}
	}
	
	// 查詢所有隱藏貼文
	public List<Post> selectHidePost() throws SQLException {
		Post post = new Post();
		post.setPostHide(1);
		
		String hql = "from Post where postHide = ?1 order by releaseDate desc";
		List<Post> resultList = this.session.createQuery(hql, Post.class).setParameter(1, post.getPostHide()).getResultList();
		return resultList;
	}
}
