package com.campingmapping.team4.spring.t401member.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class MemberApi {

    @GetMapping(path = "/show")
    @ResponseBody
    public String getMemberList() {
        return "{'name': 'mary','age': '18','add': 'tw'}";
    }

}
