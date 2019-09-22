package com.taaaaad.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类 提供了公共的代码
 */
public class Logger {

    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行(切入点方法 就是业务层方法）
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知:Logger 类中的 beforePrintLog 方法开始执行日志");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知:Logger 类中的 afterReturningPrintLog 方法开始执行日志");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知:Logger 类中的 afterThrowingPrintLog 方法开始执行日志");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知:Logger 类中的 afterPrintLog 方法开始执行日志");
    }

    /**
     * 环绕通知
     * 问题：
     *      配置了 环绕通知之后 切入点方法没有执行 但是通知方法执行了
     * 分析：
     *      通过对比 动态代理中的环绕通知方法 发现动态代理中的环绕通知有明确的切入点方法调用，我们的方法中没有调用
     * 解决：
     *      spring 框架为我们提供了一个接口 ProceedingJointPoint ,该接口有一个方法 proceed() 该方法就相当于明确调用切入点方法
     *      该方法可以作为环绕通知的方法参数，在程序执行时 spring 框架会为我们提供该接口的实现类供我们使用
     * spring 中环绕通知：
     *      它是 spring 框架为我们提供的一种可以在代码中手动控制方何时执行的方法。
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs(); // 得到方法执行的参数
            System.out.println("前置通知:Logger 类中的 afterReturningPrintLog 方法开始执行日志");
            rtValue = pjp.proceed(args);// 明确调用切入点方法
            System.out.println("后置通知:Logger 类中的 afterReturningPrintLog 方法开始执行日志");
            return rtValue;
        } catch (Throwable t) {
            System.out.println("异常通知:Logger 类中的 afterReturningPrintLog 方法开始执行日志");
            throw new RuntimeException(t);
        }finally {
            System.out.println("最终通知:Logger 类中的 afterReturningPrintLog 方法开始执行日志");
        }

    }

}
