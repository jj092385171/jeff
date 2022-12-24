package com.campingmapping.team4.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
import com.campingmapping.team4.spring.t4_01Member.model.service.impl.MemberServiceImpl;

@RestController
public class ShowMember {
	@Autowired
	MemberServiceImpl memberServiceImpl;

	@GetMapping("/ShowMember")
	public Iterable<Member> getMemberList() {
		return memberServiceImpl.showMember();
	}

}
