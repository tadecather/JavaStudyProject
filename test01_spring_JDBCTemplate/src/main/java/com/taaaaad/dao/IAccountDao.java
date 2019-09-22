package com.taaaaad.dao;

import com.taaaaad.domain.Account;

/**
 * 账户持久层接口
 */
public interface IAccountDao {
    /**
     * 根据 ID 查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);



}
