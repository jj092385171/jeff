package com.campingmapping.team4.spring.t4_01Member.model.service;

import java.util.List;

import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;




public interface MemberService {
	public List<Member> showMember();
	
	public int delte(String account);
}
