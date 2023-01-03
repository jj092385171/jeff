package com.campingmapping.team4.spring.t4_01Member.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t4_01Member.model.dao.repository.MemberRepository;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
import com.campingmapping.team4.spring.t4_01Member.model.service.MemberService;

import jakarta.transaction.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Override
	@Transactional
	public Iterable<Member> showMember() {

		return memberRepository.findAll();

	}

	@Override
	@Transactional
	public int delete(String account) {
		// TODO Auto-generated method stub
		return 0;
	}

}
