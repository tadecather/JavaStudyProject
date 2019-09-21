package com.taaaad.test;

import com.taaaad.domain.Account;
import com.taaaad.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit 进行单元测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as;


    /**
     * 测试转账功能
     */
    @Test
    public void testTransfer(){
        as.transfer("aaa", "bbb", 100f);
    }


    @Test
    public void testFindAll() {


        List<Account> accounts = as.findAllAccount();

        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

        Account account = as.findAccountById(1);

        System.out.println(account);
    }

    @Test
    public void testSave() {


        Account account = new Account();
        account.setName("4578");
        account.setMoney(45879f);

        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {

        Account account = as.findAccountById(1);

        account.setMoney(23458f);

        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        as.deleteAccount(1);
    }
}
