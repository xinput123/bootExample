package com.xinput.boot.momgo.repository;

import com.xinput.boot.momgo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao extends BaseMongoDao<Person> {

  @Autowired
  @Qualifier("mongoTemplate")
  @Override
  protected void setMongoTemplate(MongoTemplate mongoTemplate) {
    super.mongoTemplate = mongoTemplate;
  }
}
