package com.boot.multiple.aop;

import com.boot.multiple.config.DynamicDataSourceHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 第四步： 设置路由 key
 * 默认情况下，所有的查询都走从库，插入/修改/删除走主库
 */
@Aspect
@Component
public class DataSourceAop {

  @Pointcut("!@annotation(com.boot.multiple.annotation.Master) " +
      "&& (execution(* com.boot.multiple.service..*.select*(..)) " +
      "|| execution(* com.boot.multiple.service..*.get*(..)))")
  public void readPointcut() {

  }

  @Pointcut("@annotation(com.boot.multiple.annotation.Master) " +
      "|| execution(* com.boot.multiple.service..*.insert*(..)) " +
      "|| execution(* com.boot.multiple.service..*.add*(..)) " +
      "|| execution(* com.boot.multiple.service..*.update*(..)) " +
      "|| execution(* com.boot.multiple.service..*.edit*(..)) " +
      "|| execution(* com.boot.multiple.service..*.delete*(..)) " +
      "|| execution(* com.boot.multiple.service..*.remove*(..))")
  public void writePointcut() {

  }

  @Before("readPointcut()")
  public void read() {
    DynamicDataSourceHolder.slave();
  }

  @Before("writePointcut()")
  public void write() {
    DynamicDataSourceHolder.master();
  }
}
