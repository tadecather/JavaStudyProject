package com.taaaaad.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate 最基本用法
 */

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 准备数据源 Sring 内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/worktest");
        ds.setUsername("test");
        ds.setPassword("test1234");

        // 1. 创建 JdbcTemplate 对象
        JdbcTemplate jt = new JdbcTemplate();
        // 给 jt 设置数据源
        jt.setDataSource(ds);

        // 2. 执行操作
        jt.execute("insert into account(name, money) values('fff', '1000')");

    }

}
