package com.example.synu.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Like implements Serializable {

    private Integer id;

    private Integer articleId;

    private Integer userId;



}