package com.taaaaad.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate 最基本用法
 */

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取对象
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        // 3.执行操作
        jt.execute("insert into account(name, money) values('ggg', '1100')");

    }

}
