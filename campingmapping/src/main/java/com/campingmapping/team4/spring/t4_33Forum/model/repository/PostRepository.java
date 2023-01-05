package com.campingmapping.team4.spring.t4_33Forum.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t4_33Forum.model.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
