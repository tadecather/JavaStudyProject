package com.taaaaad.mybatis.sqlsession;

public interface SqlSessionFactory {
    /**
     * 用于打开一个新的 Session 对象
     * @return
     */
    SqlSession openSession();
}
