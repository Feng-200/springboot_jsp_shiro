package com.baizhi.springboot_jsp_shiro.mapper;

import com.baizhi.springboot_jsp_shiro.bean.Role;
import com.baizhi.springboot_jsp_shiro.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Feng
 * @date 2021/5/25 21:55
 */
@Repository
public interface UserDao {

    @Insert("insert into t_user values(#{id},#{username},#{password},#{salt})")
    void save(User user);

    @Select("SELECT id,username,PASSWORD,salt FROM t_user WHERE username = #{username}")
    User findByUserName(String username);


    //根据用户名查询所有角色
    @Select("SELECT * FROM t_user WHERE username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "salt",column = "salt"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select="com.baizhi.springboot_jsp_shiro.mapper.RolerDao.findRolesByUserName2"))
    })
    User findRolesByUserName(String username);   /*应该是'findUserInfo'   懒得改了*/
}
