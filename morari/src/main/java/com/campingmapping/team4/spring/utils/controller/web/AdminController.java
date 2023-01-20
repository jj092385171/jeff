package com.campingmapping.team4.spring.utils.controller.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAnyAuthority('USER')")
@RequestMapping("/admin")
public class AdminController {
    @GetMapping({ "", "/" })
    public String index() {
        return "admin";
    }

}
