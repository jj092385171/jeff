package com.campingmapping.team4.spring.t4_33Forum.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Post> findAllPost(){
		return postDao.findAllPost();
	}
	// 查單一貼文
	public Post findPostByPostId(int postId){
		return postDao.findPostByPostId(postId);
	}
	// 查會員貼文
	public List<Post> findPostByUserId(int userId){
		return postDao.findPostByUserId(userId);
	}	
	// 查詢被檢舉貼文
	public List<Post> findReportPost(){
		return postDao.findReportPost();
	}
	// 查詢隱藏貼文
	public List<Post> findHidePost(){
		return postDao.findHidePost();
	}
	
	// 新增貼文
	public void insertPost(Post post) throws ParseException{
		postDao.insertPost(post);
	}
	
	// 修改貼文
	public void updatePost(Post post) throws ParseException{
		postDao.updatePost(post);
	}
	
	// 喜歡貼文
	
	// 不喜歡貼文
	
	// 檢舉貼文
	public Boolean reportPost(int postId) {
		return postDao.reportPost(postId);
	}
	
	// 取消檢舉貼文
	public Boolean cancelReportPost(int postId) {
		return postDao.cancelReportPost(postId);
	}
	
	// 隱藏貼文
	public Boolean hidePost(int postId) throws ParseException{
		return postDao.hidePost(postId);
	}
	
	// 取消隱藏貼文
	public Boolean cancelHidePost(int postId) throws ParseException{
		return postDao.cancelHidePost(postId);
	}
	
}
