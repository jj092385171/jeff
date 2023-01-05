package com.campingmapping.team4.spring.t4_01Member.model.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
