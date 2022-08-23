package com.xinput.shard03.controller;


import com.google.common.collect.Lists;
import com.xinput.shard03.domain.entity.Member;
import com.xinput.shard03.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
@RequestMapping("/shard03")
public class MemberController {

  private static int M = 1;
  private static int F = 0;

  @Autowired
  private MemberService memberService;

  /**
   * 模拟插入数据
   */
  List<Member> userList = Lists.newArrayList();

  /**
   * 初始化插入数据
   */
  @PostConstruct
  private void getData() {
    userList.add(new Member(1L, "小小", F, 40));
    userList.add(new Member(2L, "爸爸", M, 61));
    userList.add(new Member(3L, "妈妈", F, 60));
    userList.add(new Member(4L, "爷爷", M, 84));
    userList.add(new Member(5L, "奶奶", F, 82));
    userList.add(new Member(6L, "女儿", F, 22));
    userList.add(new Member(7L, "儿子", M, 21));
    userList.add(new Member(8L, "孙子", M, 2));
    userList.add(new Member(9L, "孙女", F, 3));
  }

  /**
   * @Description: 批量保存用户
   */
  @PostMapping("/member")
  public Object saveUser() {
    return memberService.insertForeach(userList);
  }

  /**
   * @Description: 获取用户列表
   */
  @GetMapping("/member")
  public Object listUser() {
    return memberService.list();
  }
}
