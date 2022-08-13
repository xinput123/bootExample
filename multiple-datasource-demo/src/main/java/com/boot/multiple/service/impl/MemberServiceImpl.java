package com.boot.multiple.service.impl;

import com.boot.multiple.annotation.Master;
import com.boot.multiple.entity.Member;
import com.boot.multiple.mapper.MemberMapper;
import com.boot.multiple.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

  @Resource
  private MemberMapper memberMapper;

  @Override
  @Transactional
  public int insert(Member member) {
    return memberMapper.insert(member);
  }

  @Master
  @Override
  public int save(Member member) {
    return memberMapper.insert(member);
  }

  @Override
  public List<Member> selectAll() {
    return memberMapper.selectAll();
  }

  @Override
  public Member get(int id) {
    return memberMapper.get(id);
  }

  @Master
  @Override
  public String getToken(int id) {
    return memberMapper.getToken(id);
  }
}
