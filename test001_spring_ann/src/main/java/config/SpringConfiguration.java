package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Spring 中的新注解
 * Configuration
 *      作用：表明当前类时一个配置类
 *      细节： 当配置类作为 AnnotationConfigApplicationContext 对象创建的参数时，该注解可以不写
 * ComponentScan
 *      作用：用于通过注解spring创建容器要扫描的包
 *      属性：values 和 basePackages 作用一样，表示要扫描的包
 *           使用此注解相当于在 xml 中配置了
 *           <context:component-scan base-package="com.taaaad"></context:component-scan>
 *
 *
 * Bean 注解
 *      作用：将当前方法的返回值作为对象存入spring容器中
 *      属性：name 用于指定 Beand 的ID 默认值为 ID 为当前的方法名称
 *      细节： 使用注解配置时 如果方法有参数 spring 会自动从容器中获取可用的对象
 *      注入方法同 Autowired 作用一致 按照类型注入 多个对象 按照名称注释
 *
 * Scope :注明生命周期  prototype 多例模式
 *
 * import
 *      作用： 导入其他配置类
 *      属性：使用 import 注解之后，有 import 的类就是主配置类 而导入的都是子配置
 *
 * PropertySource
 *      作用：用于制定 Properties 文件的位置
 *      属性：
 *          value 指定文件的名称和路径
 *          关键字： classpath 表示类路径
 */

//@Configuration
@ComponentScan(basePackages = "com.taaaad")
@Import(JDBCConfig.class)
@PropertySource("classpath:JDBCConfig.properties")
public class SpringConfiguration {



}
