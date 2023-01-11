package com.campingmapping.team4.spring.t401member.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t401member.model.entity.Member;
import com.campingmapping.team4.spring.t401member.model.service.impl.MemberServiceImpl;

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

}
