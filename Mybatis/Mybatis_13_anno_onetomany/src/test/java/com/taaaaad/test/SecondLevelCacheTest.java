package com.taaaaad.test;

import com.taaaaad.dao.IUserDao;
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
 * 测试mybatis 中二级缓存
 */
public class SecondLevelCacheTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    private SqlSessionFactory factory;


    @Before
    public void init() throws Exception{
        // 1. 获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 根据字节输入流构键SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        // 3. 根据 SQLSessionFactory 生产一个 SqlSession
        session = factory.openSession();
        // 4. 使用 SqlSession 获取 Dao 对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
//        session.commit();
//        session.close();
        in.close();
    }

    /**
     * 测试查询一个
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(5);
        System.out.println(user);

        session.close(); // 关闭session

        SqlSession session1 = factory.openSession(); //重新打开 session
        IUserDao userDao1 = session1.getMapper(IUserDao.class);

        User user1 = userDao1.findById(5);
        System.out.println(user1);

        System.out.println(user == user1);
    }
}
