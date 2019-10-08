package com.taaaaad.dao;

import com.taaaaad.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 永不持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
