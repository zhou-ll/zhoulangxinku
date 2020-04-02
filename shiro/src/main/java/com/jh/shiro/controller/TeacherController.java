package com.jh.shiro.controller;

import com.jh.shiro.entity.DataResult;
import com.jh.shiro.entity.TeacherEntity;
import com.jh.shiro.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 *
 * @author: jh
 * @date: 2020/3/14
 * @version: 1.0
 */
@Slf4j
@RestController
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @PostMapping("shiro/addTeacherInfo")
    public DataResult addTeacherInfo(@RequestBody TeacherEntity entity){
        DataResult dataResult;
        try {
            dataResult = teacherService.transationTest(entity);
        } catch (Exception e) {
            log.error(e.getMessage());
            dataResult = new DataResult();
            dataResult.setMessage("失败");
            dataResult.setSuccess(false);
        }
        return dataResult;
    }
}
