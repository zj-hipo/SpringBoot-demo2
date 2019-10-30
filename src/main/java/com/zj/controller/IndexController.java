package com.zj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpringBoot_Demo2
 * @description: 页面控制器，控制各种页面之间的跳转
 * @author: 张军
 * @create: 2019-10-21 01:10
 **/
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/z-game")
    public String index(){

        return "index";
    }
    /*
    * 后台管理首页的Controller*/
    @RequestMapping("/indexPictures")
    public String indexPictures(){
        return "indexPictures";
    }
}
