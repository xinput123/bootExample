package com.xinput.boot.controller;

import com.google.common.collect.Maps;
import com.xinput.boot.consts.ResultCode;
import com.xinput.boot.domain.Book;
import com.xinput.boot.exception.BootBusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class Controller {

  private static Map<Long, Book> bookMap = Maps.newConcurrentMap();

  static {
    bookMap.put(1L, new Book(1L, "《红楼梦》", "曹雪芹"));
    bookMap.put(2L, new Book(2L, "《西游记》", "吴承恩"));
    bookMap.put(3L, new Book(2L, "《水浒传》", "施耐庵"));
    bookMap.put(4L, new Book(3L, "《三国演义》", "罗贯中"));
  }

  @GetMapping("/status")
  public String status() {
    return "ok";
  }

  @GetMapping("/books")
  public List<Book> query() {
    return bookMap.values().stream().collect(Collectors.toList());
  }

  @GetMapping("/books/{id}")
  public Book query(@PathVariable("id") long id) {
    return bookMap.get(id);
  }

  @GetMapping("/testBootBusinessException")
  public Book bootBusinessException() {
    throw new BootBusinessException(ResultCode.ERROR.getCode(), "书籍不存在");
  }

  @GetMapping("/testException")
  public Book exception() throws Exception {
    throw new Exception("Exception 异常");
  }

  @GetMapping("/testError")
  public Book error() {
    throw new Error("error异常");
  }

  @GetMapping("/testThrowable")
  public Book throwable() throws Throwable {
    throw new Throwable("throwable 异常");
  }
}
