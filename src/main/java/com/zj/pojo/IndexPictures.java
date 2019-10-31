package com.zj.pojo;

import lombok.Data;

/**
 * @program: SpringBoot_Demo2
 * @description: 首页的展示图片类
 * @author: 张军
 * @create: 2019-10-28 15:19
 **/
@Data
public class IndexPictures {
    private Long id;
    private String title;
    private String imgFileName;
    private String link;
    private Long weight;
    private String date;
}
