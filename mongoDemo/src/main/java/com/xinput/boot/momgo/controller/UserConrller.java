package com.xinput.boot.momgo.controller;

import com.google.common.collect.Lists;
import com.xinput.boot.momgo.bean.dto.UserDto;
import com.xinput.boot.momgo.entity.User;
import com.xinput.boot.momgo.repository.BaseBootMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserConrller {

  @Autowired
  private BaseBootMongoDao baseBootMongoDao;

  @GetMapping("users")
  public List<User> query() {
    return baseBootMongoDao.findAll(User.class);
  }

  @PostMapping("users")
  public User save(@RequestBody UserDto userDto) {
    User user = new User(userDto);
    return baseBootMongoDao.save(user);
  }

  @PostMapping("batchUser")
  public List<User> save() {
    List<User> users = Lists.newArrayList();
    users.add(new User("2", "李四", ""));
    users.add(new User("3", "王五", ""));
    users.add(new User("4", "赵六", ""));
    baseBootMongoDao.insertAll(users);
    return users;
  }

  @GetMapping("users/{id}")
  public User query(@PathVariable("id") String id) {
    return baseBootMongoDao.findById(User.class, id);
  }
}
