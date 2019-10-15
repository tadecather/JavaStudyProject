package com.taaaaad.dao;

import com.taaaaad.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */

public interface IUserDao {

    /**
     * 查询所有 用户下所有账户的信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param id
     */
    User findById(Integer id);


}
