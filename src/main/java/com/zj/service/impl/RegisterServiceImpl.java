package com.zj.service.impl;

import com.zj.mapper.RegisterMapper;
import com.zj.pojo.Customer;
import com.zj.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-05-18 07:59
 **/
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Override
    //注册用户
    //TODO，没有对密码进行MD5加密
    public void insertCustomer(Customer customer) {
        this.registerMapper.insertCustomer(customer);
    }
}
