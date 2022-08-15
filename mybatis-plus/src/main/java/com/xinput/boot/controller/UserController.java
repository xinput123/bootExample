package com.xinput.boot.controller;

import com.xinput.boot.domain.entity.User;
import com.xinput.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserMapper userMapper;

  @GetMapping("/users")
  public List<User> query() {
    return userMapper.allUsers();
  }

  @PostMapping("/users")
  public User save(@RequestBody User userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(userDto.getPassword());
    user.setCreateTime(new Date());
    userMapper.insert(user);
    return user;
  }

  @GetMapping("/users/{id}")
  public User get(@PathVariable("id") int id) {
    return userMapper.selectById(id);
  }

  @PutMapping("/users/{id}")
  public int get(@PathVariable("id") int id, @RequestBody User userDto) {
    userDto.setId(id);
    return userMapper.updateById(userDto);
  }

  @GetMapping("/users/query")
  public User get(@RequestParam("name") String name) {
    return userMapper.selectByUsername(name);
  }
}
