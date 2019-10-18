package com.zj.pojo;
import lombok.Data;
import java.sql.Timestamp;

/**
 * @program: SpringBoot_Demo2
 * @description: 实体类
 * @author: 张军
 * @create: 2019-09-29 20:12
 **/
@Data
public class News {
    private Integer newsId;
    private String newsTitle;
    private String newsContent;
    private Timestamp newsTime;//设置字段类型为timestamp。然后下面默认值填写CURRENT_TIMESTAMP 下面那个根据当前时间戳更新 勾上
    private String adminName;

}
