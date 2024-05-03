package com.example.synu.service.impl;

import com.example.synu.mapper.ArticlesMapper;
import com.example.synu.pojo.ArticleQuery;
import com.example.synu.pojo.Articles;
import com.example.synu.service.ArticleService;
import com.example.synu.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticlesMapper articlesMapper;
    @Autowired
    UserService userService;

    //查询文章总数
    public int getCountArt()
    {
        return articlesMapper.getCountArt();
    }

    //分页查询博客
    @Override
    public PageInfo<Articles> getPage(ArticleQuery query, int page, int size) {
        PageHelper.startPage(page,size);
        List<Articles> list = articlesMapper.selectPage(query);
        PageInfo<Articles> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //分页查询我自己的文章
    @Override
    public PageInfo<Articles> articleMySelect(int id, int page, int size) {
        PageHelper.startPage(page,size);
        List<Articles> list = articlesMapper.articleMySelect(id);
        PageInfo<Articles> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Articles getLikeAndView(Integer id) {
        return articlesMapper.getLikeAndView(id);
    }

    //取时间排前三的文章
    @Override
    public List<Articles> getThreeArt() {
        return articlesMapper.getThreeArt();
    }


    //新增博客
    @Override
    public int articleInsert(Articles articles) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today = dateFormat.format(currentDate);
        articles.setArticleCreateTime(today);
        articles.setArticleLastUpdateTime(today);
        return articlesMapper.articleInsert(articles);
    }

    //删除博客
    @Override
    public int articleDelete(Integer id) {
        return articlesMapper.articleDelete(id);
    }

    //得到一篇稳占彪
    public Articles getOneArticle(Integer id)
    {
        return articlesMapper.getOneArticle(id);
    }

    //修改得到的那篇文章
    @Override
    public int articleUpdate(Articles articles) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:MM");
        String today = dateFormat.format(currentDate);
        articles.setArticleLastUpdateTime(today);
        return articlesMapper.articleUpdate(articles);
    }


}
