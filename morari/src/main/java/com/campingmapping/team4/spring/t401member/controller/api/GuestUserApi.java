package com.campingmapping.team4.spring.t401member.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t401member.model.service.*;
import com.campingmapping.team4.spring.utils.config.GoogleFileUtil;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("guest/camper/api")
public class GuestUserApi {
    @Autowired
    UserService userService;
    @Autowired
    GoogleFileUtil googleFileUtil;

    @GetMapping("/shot")
    @ResponseBody
    public String getShot(HttpServletRequest request) {
        return userService.getShot(request);
    }

    // @PutMapping("/shot")
    // @ResponseBody
    // public String putShot() {

    //     return googleFileUtil();
    // }

    @GetMapping("/nickname")
    @ResponseBody
    public String getNickname(HttpServletRequest request) {
        return userService.getNickname(request);
    }

}
