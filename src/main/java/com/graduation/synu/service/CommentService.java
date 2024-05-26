package com.graduation.synu.service;

import com.graduation.synu.pojo.Articles;
import com.graduation.synu.pojo.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {

    //查询所有评论
    List<Comment> getCommentAll();

    //得到这个文章所有的评论
    List<Comment> getThisComments(Integer id);

    //发布一条评论
    void addComment(Integer id, Integer uid, String commentContent);

    //查询我的评论列表
    PageInfo<Articles> getCommentArticles(Integer id, int page, int size);

    //删除这条评论
    void deleteComment(Integer id);

    //修改这条评论
    int updateComment(Integer id,Integer uid,String commentContent);
}
