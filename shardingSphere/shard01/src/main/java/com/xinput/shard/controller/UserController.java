package com.xinput.shard.controller;

import com.xinput.shard.domain.entity.User;
import com.xinput.shard.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

  @Autowired
  private UserService userService;

  // 保存用户
  @PostMapping("users")
  public String saveUser() {
    return userService.saveOne(new User("小小", "女", 3));
  }

  // 获取用户列表
  @GetMapping("users")
  public List<User> listUser() {
    return userService.list();
  }

}
