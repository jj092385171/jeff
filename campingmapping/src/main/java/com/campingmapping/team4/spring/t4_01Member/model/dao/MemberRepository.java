package com.campingmapping.team4.spring.t4_01Member.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

}