package com.boot.multiple.config;

import com.boot.multiple.enums.DBTypeEnum;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 第一步：多数据源配置
 */
@Component // 如果没有 @Component 这个注解，myRoutingDataSource 注入不到 bean 中，为什么？
@Configurable
public class MultiDataSourceConfig {

  /**
   * 主数据源
   */
  @Bean
  @ConfigurationProperties("spring.datasource.master")
  public DataSource masterDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @ConfigurationProperties("spring.datasource.slave1")
  public DataSource slave1DataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @ConfigurationProperties("spring.datasource.slave2")
  public DataSource slave2DataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @ConfigurationProperties("spring.datasource.slave3")
  public DataSource slave3DataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "myRoutingDataSource")
  public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                        @Qualifier("slave1DataSource") DataSource slave1DataSource,
                                        @Qualifier("slave2DataSource") DataSource slave2DataSource,
                                        @Qualifier("slave3DataSource") DataSource slave3DataSource) {
    Map<Object, Object> targetDataSources = new HashMap();
    targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
    targetDataSources.put(DBTypeEnum.SLAVE1, slave1DataSource);
    targetDataSources.put(DBTypeEnum.SLAVE2, slave2DataSource);
    targetDataSources.put(DBTypeEnum.SLAVE3, slave3DataSource);

    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    // 设置默认数据库
    dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
    // 设置路由表，使用 map 的 key，value 方法得到对应数据源
    dynamicDataSource.setTargetDataSources(targetDataSources);
    return dynamicDataSource;
  }
}
