package com.taaaaad.service;

/**
 * 账户业务层接口
 */

public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 更新账户
     * @param id
     */
    void updateAccount(int id);

    /**
     * 删除账户
     * @return
     */
    int deleteAccount();
}
