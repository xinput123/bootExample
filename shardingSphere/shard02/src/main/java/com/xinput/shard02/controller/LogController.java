package com.xinput.shard02.controller;

import com.google.common.collect.Lists;
import com.xinput.shard02.domain.entity.LogDetail;
import com.xinput.shard02.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/log")
public class LogController {

  @Autowired
  private UserService userService;

  /**
   * 模拟插入数据
   */
  List<LogDetail> userList = Lists.newArrayList();

  /**
   * 初始化插入数据
   */
  @PostConstruct
  private void getData() {
    Date date = new Date();
    userList.add(new LogDetail("1001", date, "1001 登录"));
    userList.add(new LogDetail("1002", date, "1002 登录"));
    userList.add(new LogDetail("1003", date, "1003 登录"));
    userList.add(new LogDetail("1004", date, "1004 登录"));
    userList.add(new LogDetail("1005", date, "1005 登录"));
    userList.add(new LogDetail("1006", date, "1006 登录"));
    userList.add(new LogDetail("1007", date, "1007 登录"));
    userList.add(new LogDetail("1008", date, "1008 登录"));
    userList.add(new LogDetail("1009", date, "1009 登录"));
    userList.add(new LogDetail("1010", date, "1010 登录"));
    userList.add(new LogDetail("1001", date, "1001 退出"));
    userList.add(new LogDetail("1002", date, "1002 退出"));
    userList.add(new LogDetail("1003", date, "1003 退出"));
    userList.add(new LogDetail("1004", date, "1004 退出"));
    userList.add(new LogDetail("1005", date, "1005 退出"));
    userList.add(new LogDetail("1006", date, "1006 退出"));
    userList.add(new LogDetail("1007", date, "1007 退出"));
    userList.add(new LogDetail("1008", date, "1008 退出"));
    userList.add(new LogDetail("1009", date, "1009 退出"));
    userList.add(new LogDetail("1010", date, "1010 退出"));
  }

  @PostMapping("/detail")
  public String save() {
    try {
      return userService.insertForeach(userList);
    } catch (Exception e) {
      e.printStackTrace();
      return e.getMessage();
    }
  }

  @GetMapping("detail")
  public List<LogDetail> details() {
    return userService.list();
  }

}
