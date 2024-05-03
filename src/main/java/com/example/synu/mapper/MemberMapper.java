package com.example.synu.mapper;

import com.example.synu.pojo.Member;
import com.example.synu.pojo.MemberQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface MemberMapper {

    //分页查询
    List<Member> selectPage(@Param("query") MemberQuery query);

    //添加员工
    int MemInsert(Member member);

    //删除员工
    int MemDelete(Integer id);

    //查找一条员工数据
    Member GetMember(int id);

    //修改员工数据
    int MemUpdate(Member member);




}
