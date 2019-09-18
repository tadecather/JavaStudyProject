package com.taaaad.test;

import com.taaaad.domain.Account;
import com.taaaad.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit 进行单元测试
 */

public class AccountServiceTest {
    @Test
    public void testFindAll() {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        List<Account> accounts = as.findAllAccount();

        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        Account account = as.findAccountById(1);

        System.out.println(account);
    }

    @Test
    public void testSave() {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        Account account = new Account();
        account.setName("4578");
        account.setMoney(45879f);

        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        Account account = as.findAccountById(1);

        account.setMoney(23458f);

        as.updateAccount(account);
    }

    @Test
    public void testdelete() {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        as.deleteAccount(1);
    }
}
