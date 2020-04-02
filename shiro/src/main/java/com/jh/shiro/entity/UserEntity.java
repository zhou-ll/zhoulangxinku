package com.jh.shiro.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author jh
 * @date 2020/3/9
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity implements Serializable {

    /**
     * 唯一id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     *
     */
    private String username;

    public static  String getKeyName(){
        return "user:";
    }

    /**
     *
     */
    public static String getLoginTimeLockKey(String username){
        return "user:loginTime:lock:"+username;
    }

    public static String getLoginCountFailKey(String username){ return "user:loginCount:fail:"+ username; }
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 密码
     */
    private String password;
    /**
     * 页数
     */
    private Integer page;
    /**
     * 条数
     */
    private Integer size;
    /**
     * 权限
     */
    private String auth;
}
