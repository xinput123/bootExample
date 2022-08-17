package com.xinput.shard02.domain.repository;

import com.xinput.shard02.domain.entity.LogDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogDetailMapper {

  /**
   * 批量插入
   */
  int insertForeach(List<LogDetail> details);

  /**
   * 获取所有用户
   */
  List<LogDetail> selectAll();

  int insert(LogDetail record);
}