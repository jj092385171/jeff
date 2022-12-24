package com.campingmapping.team4.spring.t4_33Forum.model.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.bytecode.internal.bytebuddy.PassThroughInterceptor;

import com.campingmapping.team4.spring.t4_33Forum.controller.newPostServlet;
import com.campingmapping.team4.spring.t4_33Forum.model.dao.PostDao;
import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;
import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;

public class PostService {

	private PostDao postDao;
	
	public PostService(Session session) {
		this.postDao = new PostDao(session);
	}
	
	SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// 查所有貼文
	public List<Post> selectAllPost() throws SQLException{
		Post post = new Post();
		post.setPostHide(1);
		return postDao.selectAllPost(post);
	}
	// 查單一貼文
	public Post selectSinglePost(Post post) throws SQLException{
		return postDao.selectSinglePost(post);
	}
	// 查會員貼文
	
	
	// 新增貼文
	public void insertPost(Post post) throws SQLException, ParseException{
		// 設定userId
		post.setUserId(9);
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
		post.setReleaseDate(new Timestamp(utilReleaseDate.getTime()));
		post.setUserLike(0);
		post.setUserUnlike(0);
		post.setPostReport(0);
		post.setPostHide(0);
		postDao.insertPost(post);
	}
	
	// 修改貼文
	public void updatePost(Post post) throws SQLException, ParseException{
		// 設定現在時間
		Date utilReleaseDate = dateTime.parse(dateTime.format(new Date()));
		post.setReleaseDate(new Timestamp(utilReleaseDate.getTime()));
		post.setPostReport(0);
		postDao.updatePost(post);
	}
	
	// 喜歡貼文
	
	// 不喜歡貼文
	
	// 檢舉貼文
	public void reportPost(Post post) throws SQLException{
		post.setPostReport(1);
		postDao.reportPost(post);
	}
	
	// 查詢被檢舉貼文
	public List<Post> selectReportPost(Post post) throws SQLException{
		post.setPostReport(1);
		return postDao.selectReportPost(post);
	}
	
	// 取消檢舉貼文
	public void cancelReportPost(Post post) throws SQLException{
		post.setPostReport(2);
		postDao.cancelReportPost(post);
	}
	
	// 隱藏貼文
	public void hidePost(Post post) throws SQLException{
		post.setPostHide(1);
		postDao.changeHidePost(post);
	}
		
	// 取消隱藏貼文
	public void cancelHidePost(Post post) throws SQLException{
		post.setPostHide(0);
		postDao.changeHidePost(post);
	}
}
