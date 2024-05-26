package com.graduation.synu.controller;

import com.graduation.synu.pojo.ArticleQuery;
import com.graduation.synu.pojo.Articles;
import com.graduation.synu.service.ArticleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    //得到文章总数
    @GetMapping("/getCountArt")
    public int getCountArt()
    {
        return articleService.getCountArt();
    }

    //分页查询文章
    @GetMapping("/articleSelect")
    public PageInfo<Articles> getPage(ArticleQuery query, int page, int size)
    {
        return articleService.getPage(query, page, size);
    }

    //分页查询我自己的文章
    @GetMapping("/articleMySelect")
    public PageInfo<Articles> articleMySelect(Integer id, int page, int size)
    {
        return articleService.articleMySelect(id, page, size);
    }

    //得到该用户的点赞和浏览总量
    @GetMapping("/getLikeAndView")
    public Articles getLikeAndView(Integer id)
    {
        return articleService.getLikeAndView(id);
    }

    //取时间排前三的文章
    @GetMapping("/getThreeArt")
    public List<Articles> getThreeArt()
    {
        return articleService.getThreeArt();
    }

    //新增文章
    @PostMapping ("/articleInsert")
    public int articleInsert(@RequestParam(value = "file", required = false) MultipartFile file,
                             @RequestParam(value = "article", required = false) String articleDate) throws JsonProcessingException {
        Articles article = new Articles();
        if (articleDate != null && !articleDate.isEmpty()) {
            article = new ObjectMapper().readValue(articleDate, Articles.class);
        }
        if (file != null){
//            String oldName = articleService.getOneArticle(article.getArticleId()).getArticleImg();
//            File oldFile = new File("E:\\SYNU\\Graduation Project\\synu-pro\\src\\assets\\uploadImgs\\" + oldName);
//            if (oldFile.exists()){
//                oldFile.delete();
//            }
            //拼接name，采用随机数，保证每个图片的name不同
            UUID uuid = UUID.randomUUID();
            //图片名称
            String name = uuid + ".jpg";
            article.setArticleImg(name);
            try {
                //将文件保存指定目录
                file.transferTo(new File("E:\\SYNU\\Graduation Project\\synu-pro\\src\\assets\\uploadImgs\\" + name));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return articleService.articleInsert(article);
    }

    //删除文章
    @GetMapping("/articleDelete")
    public void articleDelete(Integer id)
    {
        articleService.articleDelete(id);
    }

    //得到一篇文章
    @GetMapping("/getOneArticle")
    public Articles getOneArticle(Integer id)
    {
        return articleService.getOneArticle(id);
    }

    //修改得到的那篇文章
    @GetMapping("/articleUpdate")
    public void articleUpdate(Articles articles)
    {
        articleService.articleUpdate(articles);
    }


}
