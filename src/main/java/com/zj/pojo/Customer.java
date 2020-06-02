package com.zj.pojo;

import lombok.Data;

/**
 * @program: SpringBoot_Demo2
 * @description: 系统用户
 * @author: 张军
 * @create: 2020-05-17 14:49
 **/
@Data
public class Customer {
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private Integer sex;
    private Integer age;
}
