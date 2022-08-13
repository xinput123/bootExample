package com.xinput.boot.momgo.config;

import com.xinput.boot.momgo.repository.BaseBootMongoDao;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import javax.annotation.Resource;

/**
 * MongoDb 配置类
 */
@Configuration
public class MongoConfig implements ApplicationListener<ContextRefreshedEvent> {

  @Resource
  private MongoTemplate mongoTemplate;

  @Bean
  public BaseBootMongoDao baseBootMongoDao() {
    return new BaseBootMongoDao(mongoTemplate);
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent refreshedEvent) {
    MongoConverter converter = mongoTemplate.getConverter();
    if (converter.getTypeMapper().isTypeKey("_class")) {
      ((MappingMongoConverter) converter).setTypeMapper(new DefaultMongoTypeMapper(null));
    }
  }
}

//public class MongoConfig {
//
//  @Resource
//  private MongoTemplate mongoTemplate;
//
//  @Bean
//  public BaseBootMongoDao baseBootMongoDao() {
//    return new BaseBootMongoDao(mongoTemplate);
//  }
//}