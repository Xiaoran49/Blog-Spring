package com.example.synu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//响应对象类
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private int status;
    private String data;
    private User user;
}
