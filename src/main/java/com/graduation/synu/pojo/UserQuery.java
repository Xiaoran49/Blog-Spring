package com.graduation.synu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery{

    private Integer userId;
    private String userNickName;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhoneNumber;
    private String userSex;
    private String userIntroduce;
    private String userRegTime;
    private Integer userAge;
    private Integer delFlag;
    private String avatar;
    private Integer userIsAdmin;

}