package com.boot.multiple.entity;

import java.io.Serializable;

public class Member implements Serializable {
  private static final long serialVersionUID = -8414705083193903019L;

  private int id;

  private String name;

  private String token;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
