package com.zj.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @program: SpringBoot_Demo2
 * @description: 将上传图片的虚拟路径与绝对路径映射
 * @author: 张军
 * @create: 2019-10-31 13:04
 **/

@Configuration
public class UploadFilePathConfig extends WebMvcConfigurerAdapter {

    @Value("${addPictures.savePath}")
    private String addPicturesSavePath;

    @Value("${addPictures.url}")
    private String addPicturesUrl;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(addPicturesUrl).addResourceLocations("file:"+addPicturesSavePath);
    }
}
