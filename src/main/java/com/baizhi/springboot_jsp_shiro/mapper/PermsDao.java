package com.baizhi.springboot_jsp_shiro.mapper;

import com.baizhi.springboot_jsp_shiro.bean.Perms;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Feng
 * @date 2021/5/27 15:16
 */
@Repository
public interface PermsDao {

    @Select("select * from t_perms where id in (select permsid from t_role_perms where roleid=#{roleid})")
    List<Perms> findPermsByRoleId(String roleid);
}
