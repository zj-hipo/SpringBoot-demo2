package com.zj.service;

import com.zj.pojo.News;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 业务层
 * @author: 张军
 * @create: 2019-09-29 20:30
 **/

public interface NewsService {
    public void addNews(News news);
    List<News> getAll();
    News selectById(Integer id);
    void updateNews(News news);
    void deleteNewsById(Integer ids);
}
