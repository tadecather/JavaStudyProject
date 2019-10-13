package com.taaaaad.dao.impl;

import com.taaaaad.dao.IUserDao;
import com.taaaaad.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1. 根据 Factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 2. 调用 SqlSession 中方法实现查询列表
        List<User> users = session.selectList("com.taaaaad.dao.IUserDao.findAll"); //能获取到配置信息的 key p配置文件中的 namespace  + 方法名称
        // 释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        // 1. 根据 Factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 2. 调用 SqlSession 中方法实现保存
        session.insert("com.taaaaad.dao.IUserDao.saveUser", user); //能获取到配置信息的 key p配置文件中的 namespace  + 方法名称
        // 释放资源
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        // 1. 根据 Factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 2. 调用 SqlSession 中方法实现保存
        session.update("com.taaaaad.dao.IUserDao.updateUser", user); //能获取到配置信息的 key p配置文件中的 namespace  + 方法名称
        // 释放资源
        session.commit();
        session.close();

    }

    public void deleteUser(Integer userId) {
        // 1. 根据 Factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 2. 调用 SqlSession 中方法实现保存
        session.update("com.taaaaad.dao.IUserDao.deleteUser", userId); //能获取到配置信息的 key p配置文件中的 namespace  + 方法名称
        // 释放资源
        session.commit();
        session.close();

    }

    public User findById(Integer id) {
        // 1. 根据 Factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 2. 调用 SqlSession 中方法实现保存
        User user = session.selectOne("com.taaaaad.dao.IUserDao.findById", id); //能获取到配置信息的 key p配置文件中的 namespace  + 方法名称
        // 释放资源
        session.close();

        return user;
    }

    public List<User> findByName(String username) {
        // 1. 根据 Factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 2. 调用 SqlSession 中方法实现保存
        List<User> users = session.selectList("com.taaaaad.dao.IUserDao.findByName", username); //能获取到配置信息的 key p配置文件中的 namespace  + 方法名称
        // 释放资源
        session.close();

        return users;
    }

    public int findTotal() {
        // 1. 根据 Factory 获取 SqlSession 对象
        SqlSession session = factory.openSession();
        // 2. 调用 SqlSession 中方法实现保存
        int count = session.selectOne("com.taaaaad.dao.IUserDao.findTotal"); //能获取到配置信息的 key p配置文件中的 namespace  + 方法名称
        // 释放资源
        session.close();
        return count;
    }
}
