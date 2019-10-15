package com.taaaaad.dao;

import com.taaaaad.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户实体类
 * 在 mybatis 中针对 CRUD 共有四种 注解 @Select @Insert @Update @Delete
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @return
     */
    @Insert("insert into user(username, address, sex, birthday) values(#{username}, #{address}, #{sex}, #{birthday})")
    void insertUser(User user);

    /**
     * 更新用户
     * @return
     */
    @Update("update user set username = #{username}, address =  #{address}, sex = #{sex}, birthday = #{birthday} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @return
     */
    @Update("delete from user where id = #{id}")
    void deleteUser(Integer id);

    /**
     * 通过ID查找用户
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
//    @Select("select * from user where username like #{name}")
    @Select("select * from user where username like '%${value}%'")
    List<User> findByName(String name);

    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user")
    int findTotal();
}
