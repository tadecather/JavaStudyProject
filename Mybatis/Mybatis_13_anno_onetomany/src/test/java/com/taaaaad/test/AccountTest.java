package com.taaaaad.test;

import com.taaaaad.dao.IAccountDao;
import com.taaaaad.dao.IUserDao;
import com.taaaaad.domain.Account;
import com.taaaaad.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Desc
 * @Author taaaaad
 */
public class AccountTest {

    private InputStream in;
    private SqlSession session;
    private IAccountDao accountDao;


    @Before
    public void init() throws Exception{
        // 1. 获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 根据字节输入流构键SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3. 根据 SQLSessionFactory 生产一个 SqlSession
        session = factory.openSession();
        // 4. 使用 SqlSession 获取 Dao 对象
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account : accounts){
            System.out.println("---------------每个账户信息----------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
