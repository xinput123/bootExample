package com.xinput.shard.domain.service;

import com.xinput.shard.domain.entity.User;

import java.util.List;

public interface UserService {

  /**
   * 获取所有用户信息
   */
  List<User> list();

  /**
   * 单个 保存用户信息
   */
  String saveOne(User user);

}