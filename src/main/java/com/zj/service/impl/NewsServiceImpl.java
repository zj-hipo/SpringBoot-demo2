package com.zj.service.impl;

import com.zj.mapper.NewsMapper;
import com.zj.pojo.News;
import com.zj.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2019-09-29 20:31
 **/
@Service
@Transactional
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    //添加
    public void addNews(News news) {

        this.newsMapper.insertNews(news);
    }

    /*
      * 查询
      * */
    public List<News> getAll() {
        return newsMapper.findAll();
    }
    /*
    * 根据id查询
    * */
    public News selectById(Integer id) {
        return newsMapper.selectById(id);
    }

   /*修改
   * */
    public void updateNews(News news) {
        newsMapper.updateNews(news);

    }

    /*删除
    * */
    public void deleteNewsById(Integer ids) {
        newsMapper.deleteNewsById(ids);

    }



}
