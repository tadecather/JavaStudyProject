package com.taaaad.dao;

import com.taaaad.domain.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个账户
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存操作
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新操作
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除操作
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 根据名称查询账户
     * @param accountName 账户名称
     * @return 根据名称返回结果 如果有唯一返回 如果没有结果返回None 如果结果集不唯一就抛出异常
     */
    Account findAccountByName(String accountName);
}
