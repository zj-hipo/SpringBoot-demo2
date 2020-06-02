package com.zj.mapper;

import com.zj.pojo.Customer;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-05-17 22:41
 **/

public interface RegisterMapper {
    //注册添加用户
    void insertCustomer(Customer customer);
}
