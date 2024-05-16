package com.example.synu.controller;

import com.example.synu.pojo.ArticleQuery;
import com.example.synu.pojo.Articles;
import com.example.synu.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    //得到文章总数
    @GetMapping("/getCountArt")
    public int getCountArt()
    {
        return articleService.getCountArt();
    }

    //分页查询文章
    @GetMapping("/articleSelect")
    public PageInfo<Articles> getPage(ArticleQuery query, int page, int size)
    {
        return articleService.getPage(query, page, size);
    }

    //分页查询我自己的文章
    @GetMapping("/articleMySelect")
    public PageInfo<Articles> articleMySelect(Integer id, int page, int size)
    {
        return articleService.articleMySelect(id, page, size);
    }

    //得到该用户的点赞和浏览总量
    @GetMapping("/getLikeAndView")
    public Articles getLikeAndView(Integer id)
    {
        return articleService.getLikeAndView(id);
    }

    //取时间排前三的文章
    @GetMapping("/getThreeArt")
    public List<Articles> getThreeArt()
    {
        return articleService.getThreeArt();
    }

    //新增文章
    @PostMapping ("/articleInsert")
    public int articleInsert(@RequestBody Articles articles)
    {
        return articleService.articleInsert(articles);
    }

    //删除文章
    @GetMapping("/articleDelete")
    public void articleDelete(Integer id)
    {
        articleService.articleDelete(id);
    }

    //得到一篇文章
    @GetMapping("/getOneArticle")
    public Articles getOneArticle(Integer id)
    {
        return articleService.getOneArticle(id);
    }

    //修改得到的那篇文章
    @GetMapping("/articleUpdate")
    public void articleUpdate(Articles articles)
    {
        articleService.articleUpdate(articles);
    }


}
