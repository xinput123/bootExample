package com.xinput.boot.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xinput.boot.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

  List<User> allUsers();

  default User selectByUsername(@Param("username") String username) {
    return selectOne(new QueryWrapper<User>().eq("username", username));
  }

  List<User> selectByIds(@Param("ids") Collection<Integer> ids);

  default IPage<User> selectPageByCreateTime(IPage<User> page, @Param("createTime") Date createTime) {
    return selectPage(page,
        new QueryWrapper<User>().gt("create_time", createTime)
//                new QueryWrapper<UserDO>().like("username", "46683d9d")
    );
  }
}
