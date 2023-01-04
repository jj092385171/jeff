package com.campingmapping.team4.spring.t4_01Member.model.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
import com.campingmapping.team4.spring.t4_01Member.model.service.impl.MemberServiceImpl;

import lombok.extern.apachecommons.CommonsLog;

@Controller
@RequestMapping("memberapi")
public class MemberApi {
	@Autowired
	MemberServiceImpl memberServiceImpl;

	@GetMapping(path = "/showall")
	@ResponseBody
	public Iterable<Member> getMemberList() {
		return memberServiceImpl.showMember();
	}

	@GetMapping("/member")
	@ResponseBody
	@EntityGraph(attributePaths = { "Member" })
	public Member getMemberById() {

		return memberServiceImpl.findMemberById(1);
	}

	@GetMapping(path = "/class2", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processResponseAction2() {
		return "hi, how are u? 你好好";
	}

	@GetMapping(path = "/class1")
	@ResponseBody
	public ResponseEntity<String> class1() {

		return new ResponseEntity<String>("custom status code(403 forbidden)", HttpStatus.FORBIDDEN);
	}

	@GetMapping(path = "/class3")
	@ResponseBody
	public ResponseEntity<String> class13() {

		return new ResponseEntity<String>("custom status code(403 forbidden)", HttpStatus.FORBIDDEN);
	}

}
