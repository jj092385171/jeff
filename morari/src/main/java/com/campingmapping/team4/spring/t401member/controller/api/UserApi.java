package com.campingmapping.team4.spring.t401member.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t401member.model.service.UserService;

@Controller
@RequestMapping("admin/camper/api")
public class UserApi {

@Autowired
UserService userService;

    @GetMapping("/showall")
    @ResponseBody
    public List<UserProfiles> getAllUser() {
        // return userService.showAllUser();
        return null;
    }
    @GetMapping("/{uid}")
    @ResponseBody
    public String getUser() {
        return null;
    }
    @DeleteMapping("/{uid}")
    @ResponseBody
    public String delUser() {
        return null;
    }
    @PutMapping("/{uid}")
    @ResponseBody
    public String updateUser() {
        return null;
    }

    



}
