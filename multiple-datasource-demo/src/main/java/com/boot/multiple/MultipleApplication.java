package com.boot.multiple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mysql 主从示例
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.boot.multiple.mapper"})
public class MultipleApplication {
  public static void main(String[] args) {
    SpringApplication.run(MultipleApplication.class, args);
  }
}
