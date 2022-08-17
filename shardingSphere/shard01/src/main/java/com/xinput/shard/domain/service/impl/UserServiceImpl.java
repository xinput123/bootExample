package com.xinput.shard.domain.service.impl;

import com.xinput.shard.domain.entity.User;
import com.xinput.shard.domain.repository.UserMapper;
import com.xinput.shard.domain.service.UserService;
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
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public List<User> list() {
    List<User> users = userMapper.selectAll();
    return users;
  }

  @Override
  public String saveOne(User user) {
    user.setCreateTime(new Date());
    user.setUpdateTime(new Date());
    user.setStatus(0);
    userMapper.insert(user);
    return "保存成功";
  }
}
