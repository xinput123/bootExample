package com.xinput.shard02.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LogDetail {

  private Long id;

  private String userId;

  private Date createTime;

  private String actionDesc;

  public LogDetail() {
  }

  public LogDetail(String userId, Date createTime, String actionDesc) {
    this.userId = userId;
    this.createTime = createTime;
    this.actionDesc = actionDesc;
  }

  public LogDetail(Long id, String userId, Date createTime, String actionDesc) {
    this.id = id;
    this.userId = userId;
    this.createTime = createTime;
    this.actionDesc = actionDesc;
  }
}
