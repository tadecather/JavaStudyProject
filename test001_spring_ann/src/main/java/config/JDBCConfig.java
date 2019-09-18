package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;



/**
 * Spring 连接数据库相关的数据类
 */
@Configuration
public class JDBCConfig {


    /**
     * 用于创建一个 QueryRunner 对象
     * @param dataSource
     * @return
     */
    @Bean(name="runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }


    @Bean(name="datasource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try{
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/worktest");
            ds.setUser("test");
            ds.setPassword("test");
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
