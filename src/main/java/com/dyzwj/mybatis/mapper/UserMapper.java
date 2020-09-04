package com.dyzwj.mybatis.mapper;

import com.dyzwj.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年08月17日 19:15:00
 */
public interface UserMapper {

    int batchInsert(List<User> userList);

    List<User> selectUser();

    int insertUser(User user);

}
