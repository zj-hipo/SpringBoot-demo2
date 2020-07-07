package com.zj.service;

import com.zj.pojo.Customer;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-05-19 12:41
 **/

public interface CustomerService {
    public List<Customer> queryAll();
    public String queryPasswordByName(String nickname);
    public List<Customer> queryUserByName(String name);
    public  List<Customer> queryNickName(String nickname);
}
