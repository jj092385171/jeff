package com.campingmapping.team4.spring.t4_33Forum.model.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_33Forum.controller.newPostServlet;
import com.campingmapping.team4.spring.t4_33Forum.model.dao.PostDao;
import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
@Service
@Transactional
public class PostService {
	@Autowired
	private PostDao postDao;
	
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
//	public PostService(Session session) {
//		this.postDao = new PostDao(session);
//	}
	
	// 查所有貼文
	public List<Post> selectAllPost() throws SQLException, ParseException{
		return postDao.selectAllPost();
	}
	// 查單一貼文
	public Post selectSinglePost(Post post) throws SQLException{
		return postDao.selectSinglePost(post);
	}
	// 查會員貼文
	
	
	// 新增貼文
	public void insertPost(Post post) throws SQLException, ParseException{
		postDao.insertPost(post);
	}
	
	// 修改貼文
	public void updatePost(Post post) throws SQLException, ParseException{
		postDao.updatePost(post);
	}
	
	// 喜歡貼文
	
	// 不喜歡貼文
	
	// 檢舉貼文
	public void reportPost(Post post) throws SQLException{
		postDao.reportPost(post);
	}
	
	// 查詢被檢舉貼文
	public List<Post> selectReportPost() throws SQLException{
		return postDao.selectReportPost();
	}
	
	// 取消檢舉貼文
	public void cancelReportPost(Post post) throws SQLException{
		postDao.cancelReportPost(post);
	}
	
	// 隱藏貼文
	public void hidePost(Post post) throws SQLException, ParseException{
		post.setPostHide(1);
		postDao.changeHidePost(post);
	}
	
	// 取消隱藏貼文
	public void cancelHidePost(Post post) throws SQLException, ParseException{
		post.setPostReport(2);
		post.setPostHide(0);
		postDao.changeHidePost(post);
	}
	
	// 查詢隱藏貼文
	public List<Post> selectHidePost() throws SQLException{
		return postDao.selectHidePost();
	}
}
