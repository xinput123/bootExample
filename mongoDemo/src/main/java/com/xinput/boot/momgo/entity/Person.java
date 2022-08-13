package com.xinput.boot.momgo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

/**
 * Person 信息
 */
@Document(value = "person")
public class Person implements Serializable {
  private static final long serialVersionUID = -4125696088740877361L;

  @MongoId
  private String userId;

  @Field("user_name")
  private String userName; // 名称

  private String address; // 地址

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
