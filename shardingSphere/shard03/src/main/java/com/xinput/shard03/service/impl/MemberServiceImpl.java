package com.xinput.shard03.service.impl;

import com.xinput.shard03.domain.entity.Member;
import com.xinput.shard03.domain.mapper.MemberMapper;
import com.xinput.shard03.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author xub
 * @Description: 用户实现类
 * @date 2019/8/8 上午9:13
 */
@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberMapper memberMapper;

  @Override
  public List<Member> list() {
    List<Member> users = memberMapper.selectAll();
    return users;
  }

  @Override
  public String insertForeach(List<Member> userList) {
    for (Member user : userList) {
      user.setCreateTime(new Date());
      user.setUpdateTime(new Date());
      user.setStatus(0);
    }
    //批量插入数据
    memberMapper.insertForeach(userList);
    return "保存成功";
  }
}
