package com.zj.controller;

import com.zj.pojo.Customer;
import com.zj.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: SpringBoot_Demo2
 * @description: 注册的Controller
 * @author: 张军
 * @create: 2020-05-17 21:43
 **/
@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    //首页跳转到注册页面
    @RequestMapping("/indextoRe")
    public String indexToRegister(){
        return "/front/register";

    }
    @RequestMapping("/register")
    public String register(Customer customer){
        //TODO,验证，如果用户已经存在，不让注册
            this.registerService.insertCustomer(customer);
        return "/front/index";
    }

}
