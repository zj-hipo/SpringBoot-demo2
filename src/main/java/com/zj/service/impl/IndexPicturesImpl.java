package com.zj.service.impl;

import com.zj.dto.IndexPicturesDto;
import com.zj.mapper.IndexPicturesMapper;
import com.zj.pojo.IndexPictures;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.zj.service.IndexPicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2019-10-30 17:18
 **/
@Service
@Transactional
public class IndexPicturesImpl implements IndexPicturesService {
    @Autowired(required = false)
    private IndexPicturesMapper indexPicturesMapper;
    /*
    * 图片的保存路径
    * */
    @Value("${addPictures.savePath}")
    private String addPicturesSavePath;

    /*
    * 图片的访问路径
    * */
    @Value("${addPictures.url}")
    private String addPicturesUrl;
    //添加图片
    public boolean addPictures(IndexPicturesDto indexPicturesDto) {
        IndexPictures indexPictures = new IndexPictures();
        indexPictures.setTitle(indexPicturesDto.getTitle());
        indexPictures.setLink(indexPicturesDto.getLink());
        indexPictures.setDate(indexPicturesDto.getDate());
        indexPictures.setWeight(indexPicturesDto.getWeight());
        if (indexPicturesDto.getImgFile() != null && indexPicturesDto.getImgFile().getSize() > 0) {
            /*
            * 给图片名字前面加个时间戳
            * 防止图片重名
            * */
            String fileName = System.currentTimeMillis() + "_" + indexPicturesDto.getImgFile().getOriginalFilename();
            File file = new File(addPicturesSavePath + fileName);
            File fileFolder = new File(addPicturesSavePath);
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            try {
                /*
                * dto中的上传文件的方法
                * */
                indexPicturesDto.getImgFile().transferTo(file);
                indexPictures.setImgFileName(fileName);
                indexPicturesMapper.addPictures(indexPictures);
                return true;
            } catch (IllegalStateException | IOException e) {
                // TODO 需要添加日志
                return false;
            }
        } else {
            return false;
        }

    }
    /*
    * 查询所有
    * */
    public List<IndexPictures> findAll() {

        return indexPicturesMapper.findPictures();
    }
}
