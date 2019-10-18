package com.zj.shiro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringBoot_Demo2
 * @description: Shrio的配置类
 * @author: 张军
 * @create: 2019-10-05 01:00
 **/
@Configuration
public class ShiroCofig {
    /*
    *创建ShiroFilterFactoryBean
    * */


    /*
    * DeaultWebSecurityManager
    * */

    /*
    * 创建Realm,@Bean意思是方法getRealm()返回的对象放入spring的环境，以便给上面的方法使用
    * */
    @Bean(name = "newsRealm")
    public NewsRealm getRealm(){
        return new NewsRealm();
    }

}
