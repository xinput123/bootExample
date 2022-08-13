package com.boot.multiple.controller;


import com.boot.multiple.entity.Member;
import com.boot.multiple.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

  @Autowired
  private MemberService memberService;

  @GetMapping("/members")
  public List<Member> query() {
    return memberService.selectAll();
  }

  @GetMapping("/members/{id}")
  public Member get(@PathVariable("id") int id) {
    return memberService.get(id);
  }

  @PostMapping("/members/{id}")
  public int insert(@PathVariable("id") int id) {
    Member member = new Member();
    member.setId(id);
    member.setName("xinput-" + id);
    member.setToken("token-" + id);
    return memberService.insert(member);
  }

  @GetMapping("/members/{id}/token")
  public String getToken(@PathVariable("id") int id) {
    return memberService.getToken(id);
  }
}
