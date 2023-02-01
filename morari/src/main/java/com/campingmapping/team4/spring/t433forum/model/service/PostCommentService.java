package com.campingmapping.team4.spring.t433forum.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t433forum.model.dao.repository.PostCommentRepository;
import com.campingmapping.team4.spring.t433forum.model.dao.repository.PostRepository;
import com.campingmapping.team4.spring.t433forum.model.dto.ShowPostComment;
import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t433forum.model.entity.PostComment;
import com.campingmapping.team4.spring.utils.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

@Service
@Transactional
public class PostCommentService {
	@Autowired
	private PostCommentRepository postCommentRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private HttpServletRequest request;

	// 依貼文查所有留言
	public List<ShowPostComment> getPostCommentByPostId(Integer postid) {
		Post post = postRepository.findById(postid).get();
		List<ShowPostComment> list = new ArrayList<>();
		postCommentRepository.findBypost(post).forEach(postcomment -> {
			ShowPostComment showPostComment = new ShowPostComment();
			showPostComment.setPostid(postcomment.getPost().getPostid());
			showPostComment.setUid(postcomment.getUserprofiles().getUid());
			showPostComment.setPostcomment(postcomment.getPostcomment());
			showPostComment.setPostcommentreport(postcomment.getPostcommentreport());
			showPostComment.setPostcommenthide(postcomment.getPostcommenthide());
			list.add(showPostComment);
		});
		return list;
	}

	// 新增留言
	public PostComment insert(PostComment postComment) {

		UUID uid = jwtService.getUId(request);

		UserProfiles userProfiles = userRepository.findById(uid).get();
		postComment.setUserprofiles(userProfiles);

		postComment.setPostcommentreport(0);
		postComment.setPostcommenthide(0);
		return postCommentRepository.save(postComment);
	}

	// // 隱藏留言
	// public void hidePostComment(PostComment postComment) throws SQLException{
	// postComment.setPostCommentHide(1);
	// postCommentDao.changeHidePostComment(postComment);
	// }

	// // 取消隱藏留言
	// public void cancelHidePostComment(PostComment postComment) throws
	// SQLException{
	// postComment.setPostCommentHide(0);
	// postCommentDao.changeHidePostComment(postComment);
	// }
}
