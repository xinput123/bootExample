package com.xinput.shard02.domain.service.impl;

import com.xinput.shard02.domain.entity.LogDetail;
import com.xinput.shard02.domain.repository.LogDetailMapper;
import com.xinput.shard02.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author xub
 * @Description: 用户实现类
 * @date 2019/8/8 上午9:13
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private LogDetailMapper logDetailMapper;

  @Override
  public List<LogDetail> list() {
    return logDetailMapper.selectAll();
  }

  @Override
  public String insertForeach(List<LogDetail> userList) {
    //批量插入数据
    logDetailMapper.insertForeach(userList);
    return "保存成功";
  }
}
