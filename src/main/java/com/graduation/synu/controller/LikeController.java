package com.graduation.synu.controller;

import com.graduation.synu.pojo.Articles;
import com.graduation.synu.pojo.User;
import com.graduation.synu.service.LikeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping("/getLikeCount")
    public int getLikeCount(Integer id)
    {
        return likeService.getLikeCount(id);
    }

    //点赞
    @GetMapping("/confirmLike")
    public void confirmLike(Integer articleId,Integer userId)
    {
        likeService.confirmLike(articleId,userId);
    }

    //取消点赞
    @GetMapping("/cancelLike")
    public void cancelLike(Integer articleId,Integer userId)
    {
        likeService.cancelLike(articleId,userId);
    }

    //是否点赞
    @GetMapping("/isLike")
    public int isLike(Integer articleId,Integer userId)
    {
        return likeService.isLike(articleId,userId);
    }

    //查询我点赞的文章
    @GetMapping("/getLikeArticles")
    public PageInfo<Articles> getLikeArticles(Integer id, int page, int size)
    {
        return likeService.getLikeArticles(id,page,size);
    }

    //查询该文章点赞的人
    @GetMapping("/showLikes")
    public List<User> showLikes(Integer id)
    {
        return likeService.showLikes(id);
    }

}
