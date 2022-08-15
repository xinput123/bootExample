package com.xinput.boot.domain.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName(value = "user")
public class User {

  /**
   * 用户编号
   */
  private Integer id;

  /**
   * 账号
   */
  private String username;

  /**
   * 密码，测试用，直接明文了
   */
  private String password;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 是否删除
   */
  @TableLogic
  private int deleted;

  public Integer getId() {
    return id;
  }

  public User setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public User setCreateTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

  public int getDeleted() {
    return deleted;
  }

  public User setDeleted(int deleted) {
    this.deleted = deleted;
    return this;
  }
}
