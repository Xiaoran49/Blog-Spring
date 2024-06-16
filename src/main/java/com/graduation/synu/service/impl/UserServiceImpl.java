package com.graduation.synu.service.impl;

import com.graduation.synu.config.MD5Config;
import com.graduation.synu.mapper.UserMapper;
import com.graduation.synu.pojo.User;
import com.graduation.synu.pojo.UserQuery;
import com.graduation.synu.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User userTest(User user) {
        return userMapper.userTest(user);
    }

    //获取用户总数
    @Override
    public int getCountUser() {
        return userMapper.getCountUser();
    }

    //查询用户姓名
    @Override
    public List<User> getUserName() {
        return userMapper.getUserName();
    }


    //用户登录
    @Override
    public User userLogin(User user) {
        //MD5加密对比
        String providedHash = MD5Config.getMD5(user.getUserPassword());
        user.setUserPassword(providedHash);
        return userMapper.userLogin(user);
    }

    //注册时候查询是否有重复用户名 1：有 0：没有
    @Override
    public int selectUserName(String userName) {
        return userMapper.selectUserName(userName);
    }

    //修改管理员
    @Override
    public int changeAdmin(Integer userId, Integer isAdmin) {
        return userMapper.changeAdmin(userId,isAdmin);
    }

    //分页查询
    @Override
    public PageInfo<User> getPage(UserQuery query, int page, int size) {
        PageHelper.startPage(page, size);
        List<User> list = userMapper.selectPage(query);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<User> userSelectAll(Integer id) {
        return userMapper.userSelectAll(id);
    }

    //修改密码
    @Override
    public int userUpdatePwd(User user) {
        String encryptedPassword = MD5Config.getMD5(user.getUserPassword());
        user.setUserPassword(encryptedPassword);
//        System.out.println("加密后的密码："+encryptedPassword);
        return userMapper.userUpdatePwd(user);
    }

    //新增用户
    @Override
    public int userInsert(User user) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today = dateFormat.format(currentDate);
        user.setUserRegTime(today);
        //MD5加密密码
        String encryptedPassword = MD5Config.getMD5(user.getUserPassword());
        user.setUserPassword(encryptedPassword);
        return userMapper.userInsert(user);
    }

    //查询单个用户
    @Override
    public User getOneUser(Integer id) {
        return userMapper.getOneUser(id);
    }

    //更新用户
    @Override
    public int userUpdate(User user) {
        return userMapper.userUpdate(user);
    }

    //删除用户
    @Override
    public int userDelete(Integer id) {
        return userMapper.userDelete(id);
    }




}
