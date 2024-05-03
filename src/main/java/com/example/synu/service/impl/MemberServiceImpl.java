package com.example.synu.service.impl;

import com.example.synu.mapper.MemberMapper;
import com.example.synu.pojo.Member;
import com.example.synu.pojo.MemberQuery;
import com.example.synu.service.MemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public PageInfo<Member> getPage(MemberQuery query, int page, int size) {
        PageHelper.startPage(page, size);
        List<Member> list = memberMapper.selectPage(query);
        PageInfo<Member> pageInfo = new PageInfo<Member>(list);
        return pageInfo;
    }

    @Override
    public int MemInsert(Member member) {
        return memberMapper.MemInsert(member);
    }

    @Override
    public int MemDelete(Integer id) {
        return memberMapper.MemDelete(id);
    }

    @Override
    public Member GetMember(int id) {
        return memberMapper.GetMember(id);
    }

    @Override
    public int MemUpdate(Member member) {
        return memberMapper.MemUpdate(member);
    }


}


