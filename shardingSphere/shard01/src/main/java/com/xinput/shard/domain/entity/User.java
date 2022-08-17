package com.xinput.shard.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * user表
 */
@Getter
@Setter
public class User {
  // 主键
  private Long id;

  // 姓名
  private String name;

  // 性别
  private String sex;

  private Integer age;

  private Date createTime;

  private Date updateTime;

  // 是否删除 1删除 0未删除
  private int status;

  public User(String name, String sex, Integer age) {
    this.name = name;
    this.sex = sex;
    this.age = age;
  }

  public User(Long id, String name, String sex, Integer age, Date createTime, Date updateTime, int status) {
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.status = status;
  }
}