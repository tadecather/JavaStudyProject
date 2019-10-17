package com.taaaaad.service;

import com.taaaaad.domain.Account;

/**
 * 账户业务层接口
 */

public interface IAccountService {

    /**
     * 通过ID获取账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账操作
     * @param sourceName 转出账户名称
     * @param targetName 注入账户名称
     * @param Money 转账金额
     */
    void transfer(String sourceName, String targetName, Float Money);
}
