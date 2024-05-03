package com.example.synu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Articles{

    private Integer articleId;
    private Integer userId;
    private String userNickName;
    private String articleTitle;
    private String articleContent;
    private String articleCreateTime;
    private String articleLastUpdateTime;
    private Integer likeCount;
    private Integer viewCount;


}