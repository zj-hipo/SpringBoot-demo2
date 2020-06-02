package com.zj.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import com.zj.pojo.News;
import com.zj.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: SpringBoot_Demo2
 * @description: 填写描述
 * @author: 张军
 * @create: 2019-10-3 21:38
 **/
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
   private NewsService newsService;
    /*视图定位
    * */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    /*
    * 添加页面
    * */
    @RequestMapping("/inputPages")
    public String inputPages(){
        return "/end/input";
    }
    //添加用户
    @RequestMapping("/addNews")
    public String addNews(News news){
       this.newsService.addNews(news);
        return"redirect:/news/findNews";
    }
    /*
    * 查询
    * model将页面所需的数据传到页面
    * */
    @RequestMapping("/findNews")
    public String findNews(Model model){
        List<News> list=newsService.getAll();
        model.addAttribute("list",list);
        return "/end/newsPages";
    }
    /*根据id查询修改用户,因为要传回页面做回显，所以要加个Model对象
    * */
    @RequestMapping("/selectById")
    public String selectById(Integer id,Model model){
        News news=newsService.selectById(id);
        model.addAttribute("news",news);
        return "/end/updateNews";
    }
    /*修改
    * */
    @RequestMapping("/editNews")
    public String updateNews(News news){
        newsService.updateNews(news);
        return "redirect:/news/findNews";
    }
    /*删除
    * */
    @RequestMapping("/deleteNews")
    public String deleteNewsById(Integer ids){
        newsService.deleteNewsById(ids);
        return "redirect:/news/findNews";
    }

}
