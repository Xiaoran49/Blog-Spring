package com.graduation.synu.mapper;



import com.graduation.synu.pojo.User;
import com.graduation.synu.pojo.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author 然然
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-02-29 15:22:28
* @Entity pojo.com.graduation.synu.User
*/
@Mapper
@Repository
public interface UserMapper {

    User userTest(User user);

    //用户总数
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
    List<User> selectPage(@Param("query") UserQuery query);

    List<User> userSelectAll();

    //新增用户
    int userInsert(User user);

    //得到一个用户的数据
    User getOneUser(Integer id);

    //修改得到的一个用户的数据
    int userUpdate(User user);

    //删除用户
    int userDelete(Integer id);


}
