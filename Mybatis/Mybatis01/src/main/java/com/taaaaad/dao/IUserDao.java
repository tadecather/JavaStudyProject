package com.taaaaad.dao;

import com.taaaaad.domain.User;

import java.util.List;

/**
 * 永不持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
