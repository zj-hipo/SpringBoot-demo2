package com.zj.dto;

import com.zj.pojo.IndexPictures;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: SpringBoot_Demo2
 * @description: IndexPictures类的数据传送类，只用来传送数据,扩展了数据库表没有的属性
 * @author: 张军
 * @create: 2019-10-30 17:25
 **/
@Data
public class IndexPicturesDto extends IndexPictures {
    private String img;
    /*
    * MultipartFile是用来接收 <input type="file" id="imgFile" class="form-control" name="imgFile" required>
    * 这个file控件的，注意imgFile的名称和input的name属性名称一样
    * */
    private MultipartFile imgFile;
}
