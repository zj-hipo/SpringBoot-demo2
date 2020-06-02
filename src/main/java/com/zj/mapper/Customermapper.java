package com.zj.mapper;

import com.zj.pojo.Customer;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-05-19 12:29
 **/

public interface Customermapper {
    /*增
    * */
    /*删
    * */
    /*改
    * */
    /*查询所有
    * */
    public List<Customer> queryAll();
    /*根据昵称查询密码
    * */
    public String queryPasswordByName(String nickname);



}
