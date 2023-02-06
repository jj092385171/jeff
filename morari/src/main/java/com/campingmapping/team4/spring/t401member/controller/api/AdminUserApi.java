package com.campingmapping.team4.spring.t401member.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailAdminWeb;
import com.campingmapping.team4.spring.t401member.model.service.*;

@Controller
@RequestMapping("admin/camper/api")
public class AdminUserApi {
    @Autowired
    UserService userService;

    @GetMapping("/showall")
    @ResponseBody
    public List<UesrDetailAdminWeb> getAllUser() {
        return userService.showAllUser();
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
