package com.campingmapping.team4.spring.t433forum.model.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t433forum.model.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

}
