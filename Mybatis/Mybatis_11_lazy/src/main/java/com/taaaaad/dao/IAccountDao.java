package com.taaaaad.dao;

import com.taaaaad.domain.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface IAccountDao {

    /**
     * 查找所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户 ID 查找账户
     * @param id
     * @return
     */
    List<Account> findAccountByUid(Integer id);

}
