package com.boot.multiple.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 第二步: Mybatis 配置
 * 由于 Spring 容器中有 5 个数据源，所以我们需要为 事务管理器 和 MyBatis 手动指定一个明确的数据源
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig {

  @Resource(name = "myRoutingDataSource")
  private DataSource myRoutingDataSource;

  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(myRoutingDataSource);
    sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
    return sqlSessionFactoryBean.getObject();
  }

  /**
   * 事务配置
   */
  @Bean
  public DataSourceTransactionManager transactionManager() {
    DataSourceTransactionManager tx = new DataSourceTransactionManager();
    tx.setDataSource(myRoutingDataSource);
    return tx;
  }
}
