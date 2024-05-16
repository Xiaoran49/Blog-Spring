package com.example.synu.controller;

import com.example.synu.pojo.LoginResponse;
import com.example.synu.pojo.User;
import com.example.synu.pojo.UserQuery;
import com.example.synu.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userTest")
    public User userTest(User user){
        return userService.userTest(user);
    }

    @GetMapping("/getCountUser")
    public int getCountUser(){
        return userService.getCountUser();
    }

    @GetMapping("/getUserName")
    public List<User> getUserName(){
        return userService.getUserName();
    }

    //登录
    @GetMapping("/userLogin")
    public ResponseEntity<LoginResponse> login(User user){
        user = userService.userLogin(user);
        if (user!= null){
                LoginResponse loginResponse = new LoginResponse(200, "登录成功！",user);
                return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        }else {
            //登陆失败
            LoginResponse loginResponse = new LoginResponse(500, "用户名或密码错误！",user);
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        }
    }

    //注册时候查询是否有重复用户名 1：有 0：没有
    @GetMapping("/selectUserName")
    public int selectUserName(String userName){
        return userService.selectUserName(userName);
    }

    //注册
    @GetMapping("/userRegister")
    public void userRegister(User user){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(currentDate);
        user.setUserRegTime(today);
        userService.userInsert(user);
    }

    //设置管理员
    @GetMapping("/changeAdmin")
    public void changeAdmin(Integer userId,Integer isAdmin){
        userService.changeAdmin(userId,isAdmin);
    }

    //分页查询
    @GetMapping("/userSelect")
    public PageInfo<User> getPage(UserQuery query, int page, int size){
        return userService.getPage(query, page, size);
    }

    //重写分页查询 查所有
    @GetMapping("/userSelectAll")
    public List<User> userSelectAll(){
        return userService.userSelectAll();
    }

    //用户新增
    @GetMapping("/userInsert")
    public void userInsert(User user){
        userService.userInsert(user);
    }

    //得到一个用户数据
    @GetMapping("/getOneUser")
    public User GetOne(Integer id){
        return userService.getOneUser(id);
    }

    //修改得到的一个用户数据
    @GetMapping("/userUpdate")
    public void userUpdate(User user){
        userService.userUpdate(user);
    }

    //用户删除
    @GetMapping("/userDelete")
    public void userDelete(Integer id){
        userService.userDelete(id);
    }

}
