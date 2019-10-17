package com.taaaaad.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        // 直接使用类
       final Producer producer = new Producer();
//        producer.saleProduct(10000);

        /**
         * 动态代理：
         *  特点：字节码 随用随创建，随用随加载
         *  作用：不修改源码的基础上，对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者： JDK 官方
         *  如何创建代理对象：
         *      使用 Proxy 类中的 newProxyInstance 方法
         *  创建代理对象的要求：
         *      被代理对象最少实现一个接口，如果没有则不能使用
         *  newProxyInstance 方法的参数
         *      CLassLoader 类加载器
         *          用于加载代理对象字节码，和被代理对象使用相同的类加载器，固定写法
         *      Class[]
         *          字节码数组 代理对象和被代理对象有相同的方法 固定写法
         *      InVacationHandler
         *          用于提供增强的代码 如何代理 一般都是写一个该接口的实现类，一般都是匿名实现类，但不是必须的
         *          此接口的实现类，谁用谁写
         *
         * 基于子类的动态代理：
         */

        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
            producer.getClass().getInterfaces(),
            new InvocationHandler() {
                /**
                 * 作用：执行代理对象的任何接口的方法都会经过该方法
                 * 方法参数含义
                 * @param proxy 代理对象的引用
                 * @param method 当前执行的方法
                 * @param args 当前执行方法所需的参数
                 * @return 和被代理对象有相同的返回值
                 * @throws Throwable
                 */
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // 增强代码
                    Object returnValue = null;
                    // 1. 获取方法执行的参数
                    Float money = (Float)args[0];
                    // 2. 判断当前方法是不是销售
                    if ("saleProduct".equals(method.getName())){
                        returnValue =  method.invoke(producer, money * 0.8f);
                    }
                    return returnValue;
                }
            });

        proxyProducer.saleProduct(10000);
    }


}
