package com.xinput.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 最基础的 Mybatis 操作。XML文件
 */
@SpringBootApplication
@MapperScan({"com.xinput.boot.mapper"})
public class MybatisXmlApplication {
  public static void main(String[] args) {
    SpringApplication.run(MybatisXmlApplication.class, args);
  }
}
