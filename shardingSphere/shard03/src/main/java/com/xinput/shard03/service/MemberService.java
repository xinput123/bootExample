package com.xinput.shard03.service;

import com.xinput.shard03.domain.entity.Member;

import java.util.List;

/**
 * @author xub
 * @Description: 用户相关接口
 * @date 2019/8/24 下午6:32
 */
public interface MemberService {

  /**
   * 获取所有用户信息
   */
  List<Member> list();

  /**
   * 批量 保存用户信息
   *
   * @param userVOList
   */
  String insertForeach(List<Member> userVOList);

}