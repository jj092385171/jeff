package com.campingmapping.team4.spring.t401member.controller.api;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.campingmapping.team4.spring.t401member.model.dto.UesrDetailguestWeb;
import com.campingmapping.team4.spring.t401member.model.service.*;
import com.campingmapping.team4.spring.utils.config.GoogleFileUtil;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("guest/camper/api")
public class GuestUserApi {
    @Autowired
    UserService userService;
    // @Autowired
    // GoogleFileUtil googleFileUtil;

    @GetMapping("/shot")
    @ResponseBody
    public String getShot(HttpServletRequest request) {
        return userService.getShot(request);
    }

    @PutMapping("/shot")
    @ResponseBody
    public String putShot(@RequestParam("uid") String id,
            @RequestParam("file") MultipartFile file) throws IOException {
        return GoogleFileUtil.uploadFile("usershot"+id, file);
    }

    @GetMapping("/nickname")
    @ResponseBody
    public String getNickname(HttpServletRequest request) {
        return userService.getNickname(request);
    }

    @GetMapping("/userdetail/{uid}")
    @ResponseBody
    public UesrDetailguestWeb getUserDetail(@PathVariable("uid") UUID uid) {
        return userService.getUserDetail(uid);
    }


}
