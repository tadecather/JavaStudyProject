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
import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author taaaaad
 */
public class MybatisAnnoTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;


    @Before
    public void init() throws Exception{
        // 1. 获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 根据字节输入流构键SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3. 根据 SQLSessionFactory 生产一个 SqlSession
        session = factory.openSession();
        // 4. 使用 SqlSession 获取 Dao 对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试保存用户
     */
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("小王");
        user.setAddress("小北京");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.insertUser(user);
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(6);
        user.setUsername("小王");
        user.setAddress("小北京");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(6);
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(5);
        System.out.println(user);
    }


    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("王");
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总数
     */
    @Test
    public void testFindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }
}
