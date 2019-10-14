package com.taaaaad.dao;

import com.taaaaad.domain.Account;
import com.taaaaad.domain.AccountUser;

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
     * 查找所有用户和账户所属用户信息
     * @return
     */
    List<AccountUser> finaAllAccount();
}
