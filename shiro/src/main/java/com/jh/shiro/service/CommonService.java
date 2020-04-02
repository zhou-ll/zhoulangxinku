/**
 * @title :  CommonService.java
 * @author: jianghua
 * @create: 2020/3/27 22:05
 * @modify:
 * @description : 公共Service
 * @version: 1.0
 */
package com.jh.shiro.service;

import com.jh.shiro.util.Result;

/**
 * @description：公共Service
 * @author: jianghua
 * @version: 1.0
 * @date: 2020/3/27 22:05
 */
public interface CommonService<T> {

    /**
     * 增加
     *
     * @param t
     * @return: Result
     */
    Result add(T t);
    /**
     * 根据id删除
     *
     * @param id
     * @return: Result
     */
    Result deleteById(Integer id);

    /**
     * 删除所有
     *
     * @return: Result
     */
    Result deleteAll();

    /**
     * 修改
     *
     * @param t
     * @return: Result
     */
    Result update(T t);

    /**
     * 根据id查询
     *
     * @param id
     * @return: Result
     */
    Result get(Integer id);

    /**
     * 查询所有
     *
     * @param id
     * @return: Result
     */
    Result list(Integer id);

    /**
     * 分页查询
     *
     * @param
     * @return: Result
     */
    Result list();
}
