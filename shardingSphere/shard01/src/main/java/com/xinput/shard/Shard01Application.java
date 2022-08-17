package com.xinput.shard;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ShardingSphere 实现读写分离
 * <p>
 * 当我们引入 druid-spring-boot-starter 包的时候，springboot 启动时会加载到 DruidDataSourceAutoConfigure，
 * 加载 {@link DruidDataSourceAutoConfigure} 会通过 DruidDataSourceWrapper 查找 jdbc 属性，因为这里使用的是
 * shardingjdbc，所以找不到jdbc属性，所以他根据 spring.datasource.druid 或者 spring.datasource 找不到。
 * <p>
 * 解决方法：
 * 方案一：如果我们用的jar包是 druid-spring-boot-starter，在启动类上排除druid自动配置
 * 方案二：使用 com.alibaba.druid 代替 com.alibaba.druid-spring-boot-starter
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class Shard01Application {
  public static void main(String[] args) {
    SpringApplication.run(Shard01Application.class, args);
  }
}
