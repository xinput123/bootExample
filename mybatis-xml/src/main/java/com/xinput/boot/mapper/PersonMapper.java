package com.xinput.boot.mapper;

import com.xinput.boot.domain.entity.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @Mapper 和 @MapperScan 异曲同工
 * @Repository 注解：用于标记是数据访问Bean对象。在 Mybatis的接口中，
 * 实际是非必要的，只是为了避免在Service中，@Autowired 注入时的警告
 * @Param 注解：声明变量名
 * - 在方法为单参数时，非必须
 * - 在方法为多参数时，必须。
 * 这是一个良好的编程习惯，禁止使用Map作为查询参数
 */
//@Mapper
@Repository
public interface PersonMapper {

  int insert(Person user);

  int updateById(Person user);

  int deleteById(@Param("id") Integer id);

  Person selectById(@Param("id") Integer id);

  Person selectByUsername(@Param("username") String username);

  List<Person> query();

  List<Person> selectByIds(@Param("ids") Collection<Integer> ids);

}
