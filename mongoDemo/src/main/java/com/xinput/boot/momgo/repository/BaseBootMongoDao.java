package com.xinput.boot.momgo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * 所有mongo的读写都通过统一的代理，所有写操作必须有日志记录
 */
public class BaseBootMongoDao {

  private static Logger logger = LoggerFactory.getLogger(BaseBootMongoDao.class);

  private MongoTemplate mongoTemplate;

  public BaseBootMongoDao(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  /**
   * 保存一个对象到mongodb
   */
  public <T> T save(T bean) {
    this.mongoTemplate.save(bean);
    return bean;
  }

  public <T> T insert(T bean) {
    this.mongoTemplate.insert(bean);
    return bean;
  }

  /**
   * 批量新增
   */
  public <T> void insertAll(List<T> beans) {
    this.mongoTemplate.insertAll(beans);
  }

  /**
   * 批量新增
   */
  public <T> void insert(List<T> beans) {
    this.mongoTemplate.insert(beans);
  }

  // 删
  public <T> void remove(Class<T> tClass, Query query) {
    this.mongoTemplate.remove(query, tClass);
  }

  public <T> void remove(T bean) {
    this.mongoTemplate.remove(bean);
  }

  /**
   * 根据条件查询出来后 再去删除
   */
  public <T> T findAndRemove(Class<T> tClass, Query query) {
    return this.mongoTemplate.findAndRemove(query, tClass);
  }

  public <T> List<T> findAllAndRemove(Class<T> tClass, Query query) {
    return this.mongoTemplate.findAllAndRemove(query, tClass);
  }

  // 改 upsert 先查询，如果没有符合条件的，会执行插入，插入的值是查询值 ＋ 更新值。

  /**
   * 按条件修改
   */
  public <T> void updateFirst(Class<T> tClass, Query query, Update update) {
    this.mongoTemplate.updateFirst(query, update, tClass);
  }

  /**
   * 批量修改
   */
  public <T> void updateMulti(Class<T> tClass, Query query, Update update) {
    this.mongoTemplate.updateMulti(query, update, tClass);
  }

  /**
   * 通过条件查询更新数据
   */
  public <T> void upsert(Class<T> tClass, Query query, Update update) {
    this.mongoTemplate.upsert(query, update, tClass);
  }

  /**
   * 查询并且修改记录
   */
  public <T> T findAndModify(Class<T> tClass, Query query, Update update) {
    return this.mongoTemplate.findAndModify(query, update, tClass);
  }

  // 查

  /**
   * 根据ID获取记录
   */
  public <T> T findById(Class<T> tClass, String id) {
    return this.mongoTemplate.findById(id, tClass);
  }

  /**
   * 根据Query查询唯一实体
   */
  public <T> T findOne(Class<T> tClass, Query query) {
    return this.mongoTemplate.findOne(query, tClass);
  }

  /**
   * 查询所有数据
   */
  public <T> List<T> findAll(Class<T> tClass) {
    return this.mongoTemplate.findAll(tClass);
  }

  /**
   * 根据条件查询实体的集合
   */
  public <T> List<T> find(Class<T> tClass, Query query) {
    return this.mongoTemplate.find(query, tClass);
  }

  /**
   * 总量
   */
  public <T> long count(Class<T> tClass) {
    Query query = new Query();
    return mongoTemplate.count(query, tClass);
  }

  /**
   * 根据query 计算总量
   */
  public <T> long count(Class<T> tClass, Query query) {
    return mongoTemplate.count(query, tClass);
  }

  /**
   * 分页查询
   *
   * @param query  查询条件，相当于 mysql where条件
   * @param orders 排序 ，相当于 mysql order 条件
   * @param skip   跳过 ，相当于 mysql limit m,n 中的 m
   * @param limit  取数据， 相当于 mysql limit m,n 中的 n
   * @return
   */
  public <T> List<T> find(Class<T> tClass, Query query, List<Sort.Order> orders, Integer skip, Integer limit) {
    if (null != orders && orders.size() > 0) {
      query.with(Sort.by(orders));
    }
    if (limit != null) {
      query.limit(limit);
    }

    if (skip != null) {
      query.skip(skip);
    }

    return mongoTemplate.find(query, tClass);
  }
}
