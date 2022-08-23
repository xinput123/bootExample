package com.xinput.shard03.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * member
 * 根据性别分库，男女分开
 * 根据年龄分表
 */
@Getter
@Setter
public class Member {

  private Long id;

  private String name;

  // 1男0女
  private Integer sex;

  private Integer age;

  private Date createTime;

  private Date updateTime;

  private Integer status;

  public Member(Long id, String name, Integer sex, Integer age) {
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.age = age;
  }

  public Member(Long id, String name, Integer sex, Integer age, Date createTime, Date updateTime, Integer status) {
    this.id = id;
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.status = status;
  }
}