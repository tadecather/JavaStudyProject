package com.taaaaad.mybatis.sqlsession;

import com.taaaaad.mybatis.cfg.Configuration;
import com.taaaaad.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.taaaaad.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory 对象
 */

public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个 SqlSessionFactory 的工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
