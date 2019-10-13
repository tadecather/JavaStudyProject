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
import java.util.ArrayList;
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

    /**
     * 测试使用 QueryVo 作为查询条件
     */
    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setUserName("老王");
//        user.setUserSex("男");
        // 查询用户通过名称
        List<User> users = userDao.findUserByCondition(user);
        for(User u : users){
            System.out.println(u);
        }
    }

    /**
     * 测试使用 QueryVo 中 的 ids
     */
    @Test
    public void testFindUserInIds(){

        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(8);
        ids.add(9);
        ids.add(12);
        vo.setIds(ids);

        // 查询用户通过名称
        List<User> users = userDao.findUserInIds(vo);
        for(User u : users){
            System.out.println(u);
        }
    }

}
