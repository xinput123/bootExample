package com.xinput.shard.domain.repository;

import com.xinput.shard.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

  // 插入一条记录
  int insert(User record);

  // 获取所有用户
  List<User> selectAll();

}