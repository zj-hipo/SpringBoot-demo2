package com.zj.controller;

import com.zj.pojo.Customer;
import com.zj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBoot_Demo2
 * @description: 登录页面的controller
 * @author: 张军
 * @create: 2019-10-24 19:20
 **/
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private CustomerService customerService;
    /*错误提示
    * */
    @RequestMapping("/{error}")
    public String showPage(@PathVariable String error){
        return "/front/error";
    }
    /*跳转登录页面
    * */
    @RequestMapping("/indexTologin")
    public String loginPage(){
        return "/front/login";
    }
    /*
    * 登录判断
    * */
    @RequestMapping("/customerLogin")
    public String login(@RequestParam("nickname")String nickname, @RequestParam("password")String password,
                        HttpSession session, RedirectAttributes attributes){
        String password1=customerService.queryPasswordByName(nickname);
        //TODO,这里有个bug就是用户名输入个错误，进行登录会出现500错误页面
        if (!StringUtils.isEmpty(nickname) &&password1.equals(password)) {
            session.setAttribute("nickname",nickname);
            return "redirect:/z-game";
        }else{
            /*
            * 如果使用了重定向，使用map数组存放msg，页面拿不到
            * 如果使用map就不能使用重定向了，要使用return直接转到页面
            * */
            attributes.addFlashAttribute("msg","用户密码错误");
            return "redirect:/login/indexTologin";
        }
    }

    /*退出账号功能
    * */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("nickname");
        return "redirect:/z-game";
    }


}
