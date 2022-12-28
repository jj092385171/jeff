package com.campingmapping.team4.spring.utils;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebSecurityConfig implements WebMvcConfigurer {
    
    // 重写 【登陆拦截/拦截放行】
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 下面这几行代码就是配置拦截器并放行部分接口
        registry.addInterceptor(null)
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html","/u/login","/css","/*.js","/excel/add","/we_xin/test","/we_xin/test2");
    }
}
