package com.example.synu.mapper;

import com.example.synu.pojo.Articles;
import com.example.synu.pojo.Like;
import com.example.synu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface LikeMapper {

    //查询该文章点赞总量
    int getLikeCount(Integer id);

    //点赞
    int confirmLike(Integer articleId,Integer userId);
    int likeCountAdd(Integer articleId);

    //取消点赞
    int cancelLike(Integer articleId,Integer userId);
    int likeCountSub(Integer articleId);

    //是否点赞
    int isLike(Integer articleId,Integer userId);

    //查询点赞文章
    List<Articles> getLikeArticles(Integer id);

    //查询点赞该文章的人
    List<User> showLikes(Integer id);

}
