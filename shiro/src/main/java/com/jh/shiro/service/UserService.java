package com.jh.shiro.service;

import com.jh.shiro.entity.DataResult;
import com.jh.shiro.entity.UserEntity;

import java.util.Map;

/**
 * 用户Service
 *
 * @author: jh
 * @date: 2020/3/10
 */
public interface UserService {
    /**
     * 获取所有用户信息
     *
     * @param
     * @return Result
     * @author jh
     * @date 2020/3/10
     */
    DataResult listUserInfo();

    /**
     * 获取用户信息
     *
     * @param name 姓名
     * @return Result
     * @author jh
     * @date 2020/3/10
     */
    DataResult getUserInfo(String name);

    /**
     * 获取用户权限
     *
     * @param id 用户id
     * @return Result
     * @author jh
     * @date 2020/3/11
     */
    DataResult getAuth(Integer id);

    /**
     *
     * @param name
     * @param password
     * @return
     */
    UserEntity login(String name, String password);

    /**
     * 用于限制
     * @param name
     * @return
     */
    String loginValdate(String name);

    /**
     * 判断当前用户是被限制登录
     * @param name
     * @return
     */
    Map<String,Object> loginUserLock(String name);

    /**
     * 获取用户权限
     *
     * @param userEntity 用户
     * @return Result
     * @author zll
     * @date 2020/3/11
     */
    DataResult saveRegister(UserEntity userEntity);

    /**
     *
     * @param userEntity
     * @return
     */
    boolean checkout(UserEntity userEntity);
}
