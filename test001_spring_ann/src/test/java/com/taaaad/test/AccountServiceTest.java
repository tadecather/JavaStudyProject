package com.taaaad.test;

import com.taaaad.domain.Account;
import com.taaaad.service.IAccountService;
import config.JDBCConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit 进行单元测试
 *
 * Spring 整合 junit 配置
 *      1。 Spring 倒入 junit的 jar 包
 *      2. 使用 junit 提供的注解将原有的 main 方法替换了，替换成 spring 提供的
 *          @RunWith
 *      3. 告知 Spring 的运行器 Spring是基于 XML 还是 注解，并说明位置
 *       @ContextConfiguration
 *       location : 指定 xml 配置文件位置 使用 classpath 表示在类路径下
 *       classes : 指定注解类所在位置
 *
 * 当使用 Spring 5.X 版本时 Spring 要求 Junit jar 必须是 4.1.2 及以上
 *
 *
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {


    @Autowired
    private IAccountService as;


    // 使用 Junit 注解 初始化对象
//    @Before
//    public void init(){
//        // 1. 获取容器
////        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
////        2. 得到业务层对象
//        as = ac.getBean("accountService", IAccountService.class);
//    }

    @Test
    public void testFindAll(){

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
