package com.example.synu.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleQuery{

    private Integer articleId;
    private String articleTitle;
    private String articleContent;
    private String articleCreateTime;
    private String articleLastUpdateTime;
    private Integer userId;
    private Integer likeCount;
    private Integer viewCount;
    private String articleImg;



}