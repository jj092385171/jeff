package com.campingmapping.team4.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @RequestMapping("/")
    String Hello() {
        return "hello";
    }
}
