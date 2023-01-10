package com.campingmapping.team4.spring.t4_01Member.model.service;

import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;

public interface MemberService {

	public Iterable<Member> showMember();

	public int delete(String account);

	public Member findMemberById(Integer id);

}
