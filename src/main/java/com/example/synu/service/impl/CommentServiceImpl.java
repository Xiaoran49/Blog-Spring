package com.example.synu.service.impl;

import com.example.synu.mapper.CommentMapper;
import com.example.synu.pojo.Articles;
import com.example.synu.pojo.Comment;
import com.example.synu.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    //查询所有评论
    @Override
    public List<Comment> getCommentAll() {
        return commentMapper.getCommentAll();
    }


    //得到这个文章所有的评论
    @Override
    public List<Comment> getThisComments(Integer id) {
        return commentMapper.getThisComments(id);
    }


    //发布一条评论
    @Override
    @Transactional
    public void addComment(Integer id, Integer uid, String commentContent) {
        commentMapper.addComment(id, uid, commentContent);
        commentMapper.CommentCountAdd(id);
    }

    //删除这条评论
    @Override
    @Transactional
    public void deleteComment(Integer id) {
        commentMapper.deleteComment(id);
        commentMapper.CommentCountSub(id);
    }

    //查询评论的文章
    @Override
    public PageInfo<Articles> getCommentArticles(Integer id, int page, int size) {
        PageHelper.startPage(page, size);
        List<Articles> list = commentMapper.getCommentArticles(id);
        PageInfo<Articles> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }



    //修改这条评论
    @Override
    public int updateComment(Integer id, Integer uid, String commentContent) {
        return commentMapper.updateComment(id, uid, commentContent);
    }
}
