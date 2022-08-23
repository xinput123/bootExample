package com.xinput.shard03;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 分库分表示例
 * 根据性别分库、根据年龄分表
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class Shard03Application {
  public static void main(String[] args) {
    SpringApplication.run(Shard03Application.class, args);
  }
}
