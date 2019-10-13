package com.taaaaad.dao;

import com.taaaaad.domain.QueryVo;
import com.taaaaad.domain.User;

import java.io.InputStream;
import java.util.List;

/**
 * 用户持久层接口
 */

public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param id
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询用户嘻嘻
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据 queryvo 查询中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的查询条件查询
     * @param user 查询的条件 可能有用户名 可能有 性别 可能有地址 也有可能都没有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据 queryvo 提供的id集合查询用户
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);


}
