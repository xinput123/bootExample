package com.boot.multiple.service;

import com.boot.multiple.entity.Member;

import java.util.List;

public interface MemberService {

  int insert(Member member);

  int save(Member member);

  List<Member> selectAll();

  Member get(int id);

  String getToken(int id);
}
