package com.xinput.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用 AOP 切面打印日志
 */
@SpringBootApplication
public class AopApplication {
  public static void main(String[] args) {
    SpringApplication.run(AopApplication.class, args);
  }
}
