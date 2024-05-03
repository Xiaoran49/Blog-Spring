package com.example.synu.service;

import com.example.synu.pojo.ArticleQuery;
import com.example.synu.pojo.Articles;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {

    //查询文章总数
    int getCountArt();

    //分页查询博客
    PageInfo<Articles> getPage(ArticleQuery query,int page,int size);

    //分页查询我自己的文章
    PageInfo<Articles> articleMySelect(int id,int page,int size);

    //得到该用户的点赞和浏览总量
    Articles getLikeAndView(Integer id);

    //取时间排前三的文章
    List<Articles> getThreeArt();

    //新增博客
    int articleInsert(Articles articles);

    //删除博客
    int articleDelete(Integer id);

    //得到一篇文章
    Articles getOneArticle(Integer id);

    //修改得到的那篇文章
    int articleUpdate(Articles articles);


}
