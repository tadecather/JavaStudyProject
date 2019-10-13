package com.taaaaad.dao;

import com.taaaaad.domain.User;

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
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据ID 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

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
     * 查询总用户数
     * @return
     */
    int findTotal();


}
