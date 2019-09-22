package com.taaaaad.jdbctemplate;

import com.taaaaad.dao.IAccountDao;
import com.taaaaad.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate 最基本用法
 */

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取对象
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        // 3.执行操作
        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        account.setMoney(1380f);

        accountDao.updateAccount(account);

    }

}
