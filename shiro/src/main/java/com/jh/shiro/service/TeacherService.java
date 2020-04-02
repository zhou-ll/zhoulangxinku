package com.jh.shiro.service;

import com.jh.shiro.entity.DataResult;
import com.jh.shiro.entity.TeacherEntity;

/**
 *
 *
 * @author: jh
 * @date: 2020/3/14
 * @version: 1.0
 */
public interface TeacherService {
    /**
     *  qqq
     *
     * @param entity
     * @return Result
     */
//    Result addTeacherInfo(TeacherEntity entity);

    DataResult transationTest(TeacherEntity entity);
}
