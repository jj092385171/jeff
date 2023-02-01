package com.campingmapping.team4.spring.t433forum.model.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t433forum.model.entity.Post;
import com.campingmapping.team4.spring.t433forum.model.entity.PostComment;

public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {

	// 依post查留言
	public List<PostComment> findBypost(Post post);
}
