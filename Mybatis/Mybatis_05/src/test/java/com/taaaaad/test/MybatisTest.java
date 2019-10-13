package com.taaaaad.test;

import com.taaaaad.dao.IUserDao;
import com.taaaaad.domain.QueryVo;
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
 * 测试 mybatis 的 CRUD 操作
 */

public class MybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before //测试方法执行之前执行
    public void init() throws Exception{
        // 1. 读取配置文件 生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 获取SqlSessionFactory 对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3. 获取 SqlSession 对象
        session = factory.openSession();
        // 4. 获取 dao 代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After // 测试方法之后执行
    public void destory() throws Exception{
        // 事务提交
        session.commit();

        // 资源释放
        session.close();
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
        user.setUserName("modify user property");
        user.setUserSex("女");
        user.setUserAddress("北京市三里屯");
        user.setUserBirthday(new Date());
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
        user.setUserName("小王");
        user.setUserSex("男");
        user.setUserAddress("北京市三里屯");
        user.setUserBirthday(new Date());

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
        userDao.deleteUser(7);
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


    /**
     * 测试使用 QueryVo 作为查询条件
     */
    @Test
    public void testFindUserByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        vo.setUser(user);

        // 查询用户通过名称
        List<User> users = userDao.findUserByVo(vo);
        for(User u : users){
            System.out.println(u);
        }
    }

}
