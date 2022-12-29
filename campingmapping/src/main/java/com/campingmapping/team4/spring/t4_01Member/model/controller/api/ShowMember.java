package com.campingmapping.team4.spring.t4_01Member.model.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
import com.campingmapping.team4.spring.t4_01Member.model.service.impl.MemberServiceImpl;

@Controller
public class ShowMember {
	@Autowired
	MemberServiceImpl memberServiceImpl;

	@GetMapping(  "/ShowMember")
	@ResponseBody
	public Iterable<Member> getMemberList() {
		return memberServiceImpl.showMember();
	}

}
