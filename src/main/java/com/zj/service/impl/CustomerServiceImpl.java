package com.zj.service.impl;

import com.zj.mapper.Customermapper;
import com.zj.pojo.Customer;
import com.zj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2020-05-19 12:42
 **/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private Customermapper customermapper;
    @Override
    public List<Customer> queryAll() {
        return customermapper.queryAll();
    }

    @Override
    public String queryPasswordByName(String nickname) {
        return customermapper.queryPasswordByName(nickname);
    }
}
