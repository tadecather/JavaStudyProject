package com.taaaaad.mybatis.sqlsession.proxy;

import com.taaaaad.mybatis.cfg.Mapper;
import com.taaaaad.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }
    /**
     * 用于对方法进行增强，我们增强就是调用 selectList 方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. 获取方法名
        String methodName = method.getName();
        // 2. 获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        // 3. 组合 Key
        String key = className + "." + methodName;
        // 4. 获取 mappers 中的 mapper 对象
        Mapper mapper = mappers.get(key);
        // 5. 判断是否有 Mapper
        if (mapper == null){
            throw new IllegalArgumentException("传入参数有误");
        }
        // 6. 调用工具类查询所有
        return new Executor().selectList(mapper, conn);
    }
}
