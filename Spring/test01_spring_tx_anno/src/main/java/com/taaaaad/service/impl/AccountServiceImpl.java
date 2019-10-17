package com.taaaaad.service.impl;

import com.taaaaad.dao.IAccountDao;
import com.taaaaad.domain.Account;
import com.taaaaad.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账户的实现类
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)// 只读型事务配置
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {

        // 2.1 根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        // 2.2 根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        // 2.3 转出账户转钱
        source.setMoney(source.getMoney() - money);
        // 2.4 转入账户加钱
        target.setMoney(target.getMoney() + money);
        // 2.5 更新转出账户
        accountDao.updateAccount(source);

        // 出错 体现事务
        int i = 1 / 0;

        // 2.6 更新转入账户
        accountDao.updateAccount(target);
    }




}
