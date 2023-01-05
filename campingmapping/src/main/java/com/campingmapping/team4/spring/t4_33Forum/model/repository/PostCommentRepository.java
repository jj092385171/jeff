package com.campingmapping.team4.spring.t4_33Forum.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.PostComment;

public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {

}
