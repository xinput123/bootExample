package com.xinput.shard03.domain.mapper;

import com.xinput.shard03.domain.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xub
 * @Description: 用户mapper
 * @date 2019/10/8 下午9:23
 */
@Mapper
public interface MemberMapper {

  /**
   * 批量插入
   */
  int insertForeach(List<Member> list);

  /**
   * 获取所有用户
   */
  List<Member> selectAll();

}