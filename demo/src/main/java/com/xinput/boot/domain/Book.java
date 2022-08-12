package com.xinput.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Serializable {
  private static final long serialVersionUID = -4974914486787752329L;
  private long bookId;
  private String bookName;
  private String author;
  private String desc;

  public Book() {
  }

  public Book(long bookId, String bookName, String author) {
    this.bookId = bookId;
    this.bookName = bookName;
    this.author = author;
  }
}
