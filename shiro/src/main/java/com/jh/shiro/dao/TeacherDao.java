package com.jh.shiro.dao;

import com.jh.shiro.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *
 * @author: jh
 * @date: 2020/3/14
 * @version: 1.0
 */
@Mapper
public interface TeacherDao {
    /**
     *
     *
     * @param entity
     * @return int
     */
    int addTeacherInfo(TeacherEntity entity);
}
