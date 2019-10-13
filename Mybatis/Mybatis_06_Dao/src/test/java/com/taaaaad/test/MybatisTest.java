package com.taaaaad.test;

import com.taaaaad.dao.IUserDao;
import com.taaaaad.dao.impl.UserDaoImpl;
import com.taaaaad.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试 mybatis 的 CRUD 操作
 */

public class MybatisTest {

    private InputStream in;
    private IUserDao userDao;

    @Before //测试方法执行之前执行
    public void init() throws Exception{
        // 1. 读取配置文件 生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 获取SqlSessionFactory 对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3. 使用工厂对象创建Dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After // 测试方法之后执行
    public void destory() throws Exception{
        in.close();

    }

    @Test
    public void testFindAll(){

        // 5. 执行查询所有方法
        List<User> users = userDao.findAll();
        for(User user: users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSaveUser(){

        User user = new User();
        user.setUsername("DaoImpl user");
        user.setSex("男");
        user.setAddress("北京市三里屯");
        user.setBirthday(new Date());
        System.out.println("保存操作之前");
        System.out.println(user);
        // 执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后");
        System.out.println(user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdateUser(){

        User user = new User();
        user.setId(12);
        user.setUsername("UserDaoImple User");
        user.setSex("男");
        user.setAddress("北京市");
        user.setBirthday(new Date());

        // 执行更新方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除方法
     * @throws Exception
     */
    @Test
    public void testDeleteUser(){
        // 执行查询方法
        userDao.deleteUser(13);
    }

    /**
     * 测试查找用户通过ID
     */
    @Test
    public void testFindById(){

        // 查询一个用户
        User user = userDao.findById(8);
        System.out.println(user);
    }

    /**
     * 测试查找用户通过ID
     */
    @Test
    public void testFindByName(){
        // 查询用户通过名称
        List<User> users = userDao.findByName("%王%");
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }


}
