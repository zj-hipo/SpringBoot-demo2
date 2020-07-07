package com.zj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zj.dto.IndexPicturesDto;
import com.zj.pojo.IndexPictures;
import com.zj.service.IndexPicturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 页面控制器，控制各种页面之间的跳转
 * @author: 张军
 * @create: 2019-10-21 01:10
 **/
@Controller
public class IndexController {
    @Autowired
    private IndexPicturesService indexPicturesService;
    @Value("${addPictures.url}")
    private String addPicturesUrl;

    @RequestMapping("/z-game")
    public String index(){
        return "/front/index";
    }

    /*
    * 后台管理首页的Controller,用来链接跳转
    * */
    @RequestMapping("/addIndexPictures")
    public String indexPictures(){

        return "/end/addIndexPictures";
    }

    /*
    * 图片添加,添加完成后返回图片列表
    * */
    @RequestMapping("/addPictures")
    public String addPictures(IndexPicturesDto indexPicturesDto){
        indexPicturesService.addPictures(indexPicturesDto);
        return "redirect:/index/findPictures";
    }

    /*
    * 图片查看,添加了分页查询
    * */
    /*FIXME 在这里修改*/
    @RequestMapping("/findPictures")
    public String findPictures(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        /*
        * 设置分页
        * */
        PageHelper.startPage(pageNum,5);

        /*
        * 在这里传dto，把dto的img属性里加入adImageUrl
        * 然后就可以在html页面显示了
        * */
        List<IndexPictures> list2=indexPicturesService.findAll();
        //将/**后的俩**去掉
        String url=addPicturesUrl.substring(0,addPicturesUrl.length()-2);
        /*
        * url+pic.getImgFileName()是虚拟路径+数据库装配那个的图片名字构成虚拟访问路径，放到IndexPictures的
        * imgFileName属性中*/
        for (IndexPictures pic : list2) {
            pic.setImgFileName(url+pic.getImgFileName());
        }
        PageInfo<IndexPictures> pageInfo = new PageInfo<IndexPictures>(list2);
        model.addAttribute("list2",pageInfo);
        return "/end/indexPicturesPages";
    }
}
