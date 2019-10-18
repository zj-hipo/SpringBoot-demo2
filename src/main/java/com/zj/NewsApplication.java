package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2019-09-29 23:06
 **/
@SpringBootApplication
@MapperScan("com.zj.mapper")
public class NewsApplication {
    public static void main(String[] args){

        SpringApplication.run(NewsApplication.class,args);
    }
}
