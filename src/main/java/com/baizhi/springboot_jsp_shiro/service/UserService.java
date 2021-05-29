package com.baizhi.springboot_jsp_shiro.service;

import com.baizhi.springboot_jsp_shiro.bean.Role;
import com.baizhi.springboot_jsp_shiro.bean.User;

import java.util.List;

/**
 * @author Feng
 */
public interface UserService {
    //注册用户
    void register(User user);

    //根据用户名查询所有角色
    User findByUserName(String username);

    //根据用户名查询所有角色
    User findRolesByUserName(String username);
}
