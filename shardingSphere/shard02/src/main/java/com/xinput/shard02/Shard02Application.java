package com.xinput.shard02;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ShardingSphere 分表
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class Shard02Application {
  public static void main(String[] args) {
    SpringApplication.run(Shard02Application.class, args);
  }
}
