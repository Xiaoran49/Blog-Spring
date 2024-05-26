package com.graduation.synu.service;

import com.graduation.synu.pojo.Articles;
import com.graduation.synu.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LikeService {

    //查询该文章点赞总量
    int getLikeCount(Integer id);

    //点赞
    void confirmLike(Integer articleId,Integer userId);

    //取消点赞
    void cancelLike(Integer articleId,Integer userId);

    //是否点赞
    int isLike(Integer articleId,Integer userId);

    //查询我点赞的文章
    PageInfo<Articles> getLikeArticles(Integer id, int page, int size);

    //查询点赞该文章的人
    List<User> showLikes(Integer id);
}
