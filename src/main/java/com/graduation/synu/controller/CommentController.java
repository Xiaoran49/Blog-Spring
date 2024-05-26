package com.graduation.synu.controller;

import com.graduation.synu.pojo.Articles;
import com.graduation.synu.pojo.Comment;
import com.graduation.synu.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //得到所有评论
    @GetMapping("/getCommentAll")
    public List<Comment> getCommentAll()
    {
        return commentService.getCommentAll();
    }

    //得到这个文章的所有评论
    @GetMapping("/getThisComments")
    public List<Comment> getThisComments(Integer id)
    {
        return commentService.getThisComments(id);
    }

    //发布一条评论
    @GetMapping("/addComment")
    public void addComment(Integer id,Integer uid,String commentContent)
    {
        commentService.addComment(id,uid,commentContent);
    }

    //查询评论的文章
    @GetMapping("/getCommentArticles")
    public PageInfo<Articles> getCommentArticles(Integer id, int page, int size)
    {
        return commentService.getCommentArticles(id,page, size);
    }

    //删除这条评论
    @GetMapping("/deleteComment")
    public void deleteComment(Integer id)
    {
        commentService.deleteComment(id);
    }

    //修改这条评论
    @GetMapping("/updateComment")
    public void updateComment(Integer id,Integer uid,String commentContent)
    {
        commentService.updateComment(id,uid,commentContent);
    }
}
