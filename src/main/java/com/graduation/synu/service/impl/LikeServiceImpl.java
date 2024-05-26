package com.graduation.synu.service.impl;

import com.graduation.synu.mapper.LikeMapper;
import com.graduation.synu.pojo.Articles;
import com.graduation.synu.pojo.User;
import com.graduation.synu.service.LikeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeMapper likeMapper;

    //查询该文章点赞总量
    @Override
    public int getLikeCount(Integer id) {
        return likeMapper.getLikeCount(id);
    }

    //点赞
    @Override
    @Transactional
    public void confirmLike(Integer articleId, Integer userId) {
        likeMapper.confirmLike(articleId,userId);
        likeMapper.likeCountAdd(articleId);
    }

    //取消点赞
    @Override
    @Transactional
    public void cancelLike(Integer articleId, Integer userId) {
        likeMapper.cancelLike(articleId,userId);
        likeMapper.likeCountSub(articleId);
    }

    //是否点赞
    @Override
    public int isLike(Integer articleId, Integer userId) {
        return likeMapper.isLike(articleId,userId);
    }

    //查询我点赞的文章
    @Override
    public PageInfo<Articles> getLikeArticles(Integer id, int page, int size) {
        PageHelper.startPage(page,size);
        List<Articles> list = likeMapper.getLikeArticles(id);
        PageInfo<Articles> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<User> showLikes(Integer id) {
        return likeMapper.showLikes(id);
    }
}
