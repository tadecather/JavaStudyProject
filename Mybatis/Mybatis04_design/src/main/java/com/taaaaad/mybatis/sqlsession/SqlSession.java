package com.taaaaad.mybatis.sqlsession;

/**
 * 和数据库交互的核心类
 * 可以创建 Dao 接口的代理对象
 */

public interface SqlSession {

    /**
     * 根据参数创建代理对象 参数是 dao 接口字节码
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
