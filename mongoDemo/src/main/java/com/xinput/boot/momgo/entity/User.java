package com.xinput.boot.momgo.entity;

import com.xinput.boot.momgo.bean.dto.UserDto;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Document(value = "user")
public class User implements Serializable {
  private static final long serialVersionUID = 7729842145688639443L;

  @MongoId
  private String id;

  private String name;

  private String idCard;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public User() {
  }

  public User(String id, String name, String idCard) {
    this.id = id;
    this.name = name;
    this.idCard = idCard;
  }

  public User(UserDto userDto) {
    this.id = userDto.getId();
    this.name = userDto.getName();
    this.idCard = userDto.getIdCard();
  }
}
