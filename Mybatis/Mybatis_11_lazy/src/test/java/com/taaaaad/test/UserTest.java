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
 * 测试 mybatis 的 CRUD 操作
 */

public class UserTest {

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
    public void destroy() throws Exception{
        // 事务提交
        session.commit();

        // 资源释放
        session.close();
        in.close();
    }

    /**
     * 测试查询所有账号，还要获取到账号所属用户信息
     */
    @Test
    public void testFindAll(){
        // 执行查询所有方法
        List<User> users = userDao.findAll();
//        for(User user: users) {
//            System.out.println("每个用户信息");
//            System.out.println(user);
////            System.out.println(user.getAccounts());
//        }
    }



}
