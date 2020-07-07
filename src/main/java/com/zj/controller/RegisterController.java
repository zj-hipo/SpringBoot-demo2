package com.zj.controller;

import com.zj.pojo.Customer;
import com.zj.service.CustomerService;
import com.zj.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
    @Autowired
    private CustomerService customerService;
    //首页跳转到注册页面
    @RequestMapping("/indextoRe")
    public String indexToRegister(){
        return "/front/register";

    }
    @RequestMapping("/register")
    public String register(Customer customer,Model model){
        //TODO,验证，如果用户已经存在，不让注册
        String name=customer.getUsername();
        /*
        * 假如name不存在于数据库，这里cust是个[],不是null
        *null判断是判断有没有对list集合bai分配内存空间，而不是list里面内容是否为空。
        * new一个user对象，判断user的list内容是否为空，出现异常。这是因为， 
        * 使用isEmpty()和size()的前提是，list是一个空集合，而不是null，否则会抛异常。 */
        List<Customer> cust=customerService.queryUserByName(name);
        /*
        * 创建了数组，数组的长度为0，是一个空数组，但是array不是null，它也是一个对象，只不过它的元素个数为0
        * 数组为null：是创建了数组的引用，但在堆中并没有数组中的元素
        *判断集合不为空常采用cust!=null&&!cust.isEmpty()
        * */
        if (cust!=null&&!cust.isEmpty()) {
            model.addAttribute("msg","用户已存在，请重新注册");
            System.out.println("账户已存在");
            return "/front/register";
        }else {
            this.registerService.insertCustomer(customer);
        }
        return "/front/index";

    }
    /*检测昵称是否重复
    * */
    @RequestMapping("/checkNickName")
    @ResponseBody
    public Boolean checkNickName(String nickname){
        Boolean flag;
        List<Customer> list=customerService.queryNickName(nickname);
        if (list != null&&!list.isEmpty()) {
            //说明昵称存在
            flag=false;
        }else {
            flag=true;
        }
        System.out.println(flag);
        return flag;
    }

}
