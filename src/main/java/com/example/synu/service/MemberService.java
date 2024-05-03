package com.example.synu.service;

import com.example.synu.pojo.Member;
import com.example.synu.pojo.MemberQuery;
import com.github.pagehelper.PageInfo;


public interface MemberService {

    //分页查询
    PageInfo<Member> getPage(MemberQuery query, int page, int size);

    //添加员工
    int MemInsert(Member member);

    //删除员工
    int MemDelete(Integer id);

    //查找一个员工数据
    Member GetMember(int id);

    //修改员工数据
    int MemUpdate(Member member);

}
