package com.campingmapping.team4.spring.t4_33Forum.model.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;

import util.HibernateUtils;

public class PostDao {

	private SessionFactory factory;
	private Session session;
	
	public PostDao(Session session) {
		// 取得工廠
//		this.factory = HibernateUtils.getSessionFactory();
		// 取得連線
//		this.session = factory.getCurrentSession();
		this.session = session;
	}

	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// 查所有貼文
	public List<Post> selectAllPost(Post post) {
		String hql = "from Post where postHide != ?1 order by releaseDate desc";
		List<Post> resultList = this.session.createQuery(hql, Post.class).setParameter(1, post.getPostHide()).getResultList();
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
	public void insertPost(Post post)throws SQLException{
		this.session.save(post);
	}
	
	// 修改貼文
	public void updatePost(Post post) throws SQLException {
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
		Post result = this.session.get(Post.class, post.getPostId());
		if(result != null && result.getPostReport() == 0) {
			result.setPostReport(post.getPostReport());
			return true;
		}
		return false;
	}
	
	// 查詢被檢舉貼文
	public List<Post> selectReportPost(Post post) throws SQLException {
		String hql = "from Post where postReport = ?1 and postHide !=?2 order by releaseDate desc";
		List<Post> resultList = this.session.createQuery(hql, Post.class).setParameter(1, post.getPostReport()).setParameter(2, post.getPostHide()).getResultList();
		return resultList;
	}
	
	// 取消檢舉貼文
	public Boolean cancelReportPost(Post post) throws SQLException {
		Post result = this.session.get(Post.class, post.getPostId());
		if(result != null) {
			result.setPostReport(post.getPostReport());
			return true;
		}
		return false;
	}
	
	// 變更是否隱藏貼文
	public void changeHidePost(Post post) throws SQLException {
		Post result = this.session.get(Post.class, post.getPostId());
		if(result != null) {
			result.setReleaseDate(post.getReleaseDate());
			result.setPostHide(post.getPostHide());
		}
	}
	
	// 查詢隱藏貼文
	public List<Post> selectHidePost(Post post) throws SQLException {
		String hql = "from Post where postHide = ?1 order by releaseDate desc";
		List<Post> resultList = this.session.createQuery(hql, Post.class).setParameter(1, post.getPostHide()).getResultList();
		return resultList;
	}
}
