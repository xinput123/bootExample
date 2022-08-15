package com.xinput.boot.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "persons")
public class Person {

  /**
   * 用户编号
   * strategy设置使用数据库主键自增策略；
   * generator 设置插入完成后，查询最后生成的 ID 填充到该属性中
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
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

  public Integer getId() {
    return id;
  }

  public Person setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public Person setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Person setPassword(String password) {
    this.password = password;
    return this;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public Person setCreateTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }
}
