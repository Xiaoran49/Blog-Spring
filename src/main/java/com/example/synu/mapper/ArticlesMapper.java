package com.example.synu.mapper;

import com.example.synu.pojo.ArticleQuery;
import com.example.synu.pojo.Articles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ArticlesMapper {

    //文章总数
    int getCountArt();

    //分页查询
    List<Articles> selectPage(@Param("query") ArticleQuery query);

    //分页查询我自己的文章
    List<Articles> articleMySelect(Integer id);

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
