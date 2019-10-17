package com.taaaad.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试QueryRunner 是否单例
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner(){
        // 1. 获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 2. 获取QueryRunner 对象
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);

        System.out.println(runner == runner1);

    }
}
