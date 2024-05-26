package com.graduation.synu.mapper;

import com.graduation.synu.pojo.Articles;
import com.graduation.synu.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CommentMapper {

    //查询所有评论
    List<Comment> getCommentAll();

    //得到这个文章所有的评论
    List<Comment> getThisComments(Integer id);

    //发布一条评论
    int addComment(Integer id, Integer uid, String commentContent);
    int CommentCountAdd(Integer articleId);

    //删除这条评论
    int deleteComment(Integer id);
    int CommentCountSub(Integer articleId);

    //查询评论文章列表
    List<Articles> getCommentArticles(Integer id);



    //修改这条评论
    int updateComment(Integer id,Integer uid,String commentContent);


}
