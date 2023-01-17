package com.campingmapping.team4.spring.t433forum.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/forum")
public class ForumAdminController {
    @GetMapping("/forumadminindex")
    public String index() {
        return "/forum/admin/admin";
    }

}
