package com.taaaaad.dao;

import com.taaaaad.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 用户实体类
 * 在 mybatis 中针对 CRUD 共有四种 注解 @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     * Result 属性
     */
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.taaaaad.dao.IAccountDao.findAccountByUid",
                            fetchType = FetchType.LAZY))
    })
    @Select("select * from user")
    List<User> findAll();

    /**
     * 通过ID查找用户
     * @return
     */
    @ResultMap("userMap")
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    @ResultMap("userMap")
    @Select("select * from user where username like #{name}")
    List<User> findByName(String name);

}
