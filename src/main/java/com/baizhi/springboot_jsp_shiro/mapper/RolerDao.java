package com.baizhi.springboot_jsp_shiro.mapper;

import com.baizhi.springboot_jsp_shiro.bean.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Feng
 * @date 2021/5/27 14:26
 */
@Repository
public interface RolerDao {
    @Select("SELECT * FROM t_role WHERE id in (select roleid from t_user_role where userid=#{userid})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "perms",column = "id",javaType = java.util.List.class,many = @Many(select = "com.baizhi.springboot_jsp_shiro.mapper.PermsDao.findPermsByRoleId"))

    })
    List<Role> findRolesByUserName2(String userid);
}
