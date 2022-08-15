package com.xinput.boot.mapper;

import com.xinput.boot.domain.entity.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface PersonMapper extends BaseMapper<Person> { // 继承的是，我们定义的 BaseMapper 接口

  default Person selectByUsername(@Param("username") String username) {
    Example example = new Example(Person.class);
    // 创建 Criteria 对象，设置 username 查询条件
    example.createCriteria().andEqualTo("username", username);
    // 执行查询
    return selectOneByExample(example);
  }

  List<Person> selectByIds(@Param("ids") Collection<Integer> ids);

  default List<Person> selectListByCreateTime(@Param("createTime") Date createTime) {
    Example example = new Example(Person.class);
    // 创建 Criteria 对象，设置 create_time 查询条件
    example.createCriteria().andGreaterThan("createTime", createTime);
    return selectByExample(example);
  }
}
