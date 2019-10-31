package com.zj.mapper;

import com.zj.pojo.IndexPictures;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 首页图片的mapper
 * @author: 张军
 * @create: 2019-10-30 17:09
 **/

public interface IndexPicturesMapper {
    @Insert("INSERT INTO index_picture(title,img_file_name,date) VALUES(#{title}, #{imgFileName}, #{date})")
    void addPictures(IndexPictures indexPictures);
    /*
    * 查询
    * */
    @Select("SELECT title,img_file_name,date FROM index_picture")
    List<IndexPictures> findPictures();
}
