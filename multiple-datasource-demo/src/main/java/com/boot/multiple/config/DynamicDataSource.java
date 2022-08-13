package com.boot.multiple.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 第三步: 3.2 获取路由 key
 * 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    return DynamicDataSourceHolder.get();
  }
}
