package com.zj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpringBoot_Demo2
 * @description: 登录页面的controller
 * @author: 张军
 * @create: 2019-10-24 19:20
 **/
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/indexTologin")
    public String login(){
        return "/front/login";
    }
}
