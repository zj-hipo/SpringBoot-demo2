package com.zj.service;

import com.zj.dto.IndexPicturesDto;
import com.zj.pojo.IndexPictures;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2019-10-30 17:16
 **/

public interface IndexPicturesService {
    boolean addPictures(IndexPicturesDto indexPicturesDto);
    List<IndexPictures> findAll();
    /*删除*/
    void deletePicById(Integer ids);
}
