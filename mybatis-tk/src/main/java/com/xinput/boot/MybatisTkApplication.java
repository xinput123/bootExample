package com.xinput.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

// 注意，要换成 tk 提供的 @MapperScan 注解
@SpringBootApplication
@MapperScan({"com.xinput.boot.mapper"})
public class MybatisTkApplication {
  public static void main(String[] args) {
    SpringApplication.run(MybatisTkApplication.class, args);
  }
}
