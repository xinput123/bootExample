package com.boot.multiple.mapper;

import com.boot.multiple.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {

  int insert(Member member);

  void save(Member member);

  List<Member> selectAll();

  Member get(int id);

  String getToken(int id);
}
