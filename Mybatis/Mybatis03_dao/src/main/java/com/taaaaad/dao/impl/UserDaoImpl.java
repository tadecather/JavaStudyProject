package com.taaaaad.dao.impl;

import com.taaaaad.dao.IUserDao;
import com.taaaaad.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * dao 实现类
 */
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1. 使用工厂创建 sqlSession 对象
        SqlSession session = factory.openSession();
        // 2. 使用 SqlSession 执行查询所有方法
        List<User> users = session.selectList("com.taaaaad.dao.IUserDao.findAll");
        session.close();
        // 3. 返回查询结果
        return users;
    }
}
