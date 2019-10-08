package com.taaaaad.test;

import com.taaaaad.dao.IUserDao;
import com.taaaaad.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * MybatisTest 测试
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception{
        // 1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用工厂创建 SqlSession 对象
        SqlSession session = factory.openSession();
        // 4. 使用 SqlSession 创建 Dao 接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        // 5. 使用 代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        // 6. 释放资源
        session.close();
        in.close();

    }
}
