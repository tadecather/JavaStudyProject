package com.taaaad.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接工具类
 * 用于从数据源中获取一个连接 并且和线程绑定
 */
@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;


    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){

        try{
            //1. 先从 ThreadLocal 上获取
            Connection conn = tl.get();
            // 2. 判断 当前线程上是否有连接
            if (conn == null){
                // 3. 当前线程无连接时从数据源中获取一个连接 并且存入 ThreadLocal 中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 解绑线程和连接
     */
    public void removeConnection(){
       tl.remove();
    }
}
