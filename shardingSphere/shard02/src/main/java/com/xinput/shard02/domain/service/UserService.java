package com.xinput.shard02.domain.service;

import com.xinput.shard02.domain.entity.LogDetail;

import java.util.List;

public interface UserService {

  /**
   * 获取所有用户信息
   */
  List<LogDetail> list();

  /**
   * 批量 保存用户信息
   *
   * @param userVOList
   */
  String insertForeach(List<LogDetail> userVOList);

}