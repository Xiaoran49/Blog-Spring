package com.example.synu.service;



import com.example.synu.pojo.User;
import com.example.synu.pojo.UserQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {


    User userTest(User user);

    //查询用户总数
    int getCountUser();

    //查询用户姓名
    List<User> getUserName();

    //用户登录
    User userLogin(User user);

    //注册时候查询是否有重复用户名 1：有 0：没有
    int selectUserName(String userName);

    //修改管理员
    int changeAdmin(Integer userId,Integer isAdmin);

    //分页查询
    PageInfo<User> getPage(UserQuery query, int page, int size);

    //重写分页查询 查所有
    List<User> userSelectAll();



    //用户新增
    int userInsert(User user);

    //得到一个用户的数据
    User getOneUser(Integer id);

    //修改得到的一个用户数据
    int userUpdate(User user);

    //用户删除
    int userDelete(Integer id);

}
