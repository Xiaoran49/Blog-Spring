package com.example.synu.controller;

import com.example.synu.pojo.Member;
import com.example.synu.pojo.MemberQuery;
import com.example.synu.service.MemberService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    //查找所有数据分页查询
    @GetMapping("/MemAll")
    public PageInfo<Member> getPage(MemberQuery query, int page, int size){
        return memberService.getPage(query,page,size);
    }

    //插入员工数据
    @GetMapping("/MemInsert")
    public int MemInsert(Member member){
        System.out.println(member);
        return memberService.MemInsert(member);
    }

    //删除员工数据
    @GetMapping("MemDelete")
    public int MemDelete(int id){
        return memberService.MemDelete(id);
    }

    //得到一个员工数据
    @GetMapping("getMember")
    public Member GetMember(int id){
        return memberService.GetMember(id);
    }

    //修改员工数据
    @GetMapping("MemUpdate")
    public int MemUpdate(Member member){
        return memberService.MemUpdate(member);
    }
}
