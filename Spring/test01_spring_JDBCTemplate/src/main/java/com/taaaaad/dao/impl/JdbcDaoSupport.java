//package com.taaaaad.dao.impl;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
///**
// * 用于抽取 dao 中的重复代码
// */
//public class JdbcDaoSupport {
//    private JdbcTemplate jdbcTemplate;
//
//    private DataSource dataSource;
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//        if (jdbcTemplate == null) {
//            jdbcTemplate = createJdbcTemplate(dataSource);
//        }
//    }
//
//    private JdbcTemplate createJdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//}
