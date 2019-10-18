package com.zj.mapper;

import com.zj.pojo.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 操作数据库的接口
 * @author: 张军
 * @create: 2019-09-29 20:18
 **/
//@Mapper,在启动类上写了@MapperScan("com.zj.mapper")，就不用在mapper上写@Mapper这个注解了
public interface NewsMapper {
    //添加功能
    @Insert("INSERT INTO news(NewsTitle,NewsContent,AdminName) VALUES(#{newsTitle}, #{newsContent}, #{adminName})")
    void insertNews(News news);
    /*
    * 查询
    * */
    @Select("SELECT NewsID,NewsTitle,NewsContent,AdminName ,NewsTime FROM news")
    List<News> findAll();
    /*
    * 根据id查询用户，更新
    * 注意这里的id
    * */
    @Select("SELECT NewsID,NewsTitle,NewsContent,AdminName FROM news WHERE NewsID=#{id}")
    News selectById(Integer id);
    /*修改
    *这里的NewsID=#{newsId}为什么用的是newsId
     *  */
    @Update("UPDATE news set NewsTitle=#{newsTitle},NewsContent=#{newsContent},AdminName=#{adminName} WHERE NewsID=#{newsId}")
    void updateNews(News news);
    /*
    * 删除*/
    @Delete("DELETE FROM news WHERE NewsID=#{ids}")
    void deleteNewsById(Integer ids);
}
