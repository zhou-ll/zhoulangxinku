package com.jh.shiro.service.impl;

import com.jh.shiro.dao.TeacherDao;
import com.jh.shiro.dao.UserDao;
import com.jh.shiro.entity.DataResult;
import com.jh.shiro.entity.TeacherEntity;
import com.jh.shiro.entity.UserEntity;
import com.jh.shiro.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherDao teacherDao;

    @Resource
    private UserDao userDao;

    /**
     * @Transactional无效的原因
     * 1.检查你方法是不是public的
     * 2.你的异常类型是不是unchecked异常,如果我想check异常也想回滚需在
     * 注解上面写明异常类型(rollbackFor = Exception.class)
     * 3.数据库引擎要支持事务，如果是MySQL，注意表要使用支持事务的引擎，
     * 比如innodb，如果是myisam，事务是不起作用的
     * 4.检查是不是同一个类中的方法调用（如a方法调用同一个类中的b方法）
     * 5.异常是不是被你catch住了
     */
    //@Transactional(rollbackFor = Exception.class)
    public DataResult addTeacherInfo(TeacherEntity entity) {
        DataResult dataResult = new DataResult();
        UserEntity userEntity = new UserEntity();
        int cnt = teacherDao.addTeacherInfo(entity);
        userEntity.setId(4);
        userEntity.setName(entity.getName());
        int num = userDao.updateUserInfo(userEntity);
        dataResult.setMessage("成功");
        dataResult.setSuccess(true);
        dataResult.setData(cnt + num);
        int num1 = 2 / 0;
        return dataResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult transationTest(TeacherEntity entity) {
        DataResult dataResult;
        try {
            dataResult = addTeacherInfo(entity);
        } catch (Exception e) {
            dataResult = new DataResult();
            dataResult.setMessage("同类方法保存");
            log.error("错误: {}", e.getMessage());
            throw e;
        }
        return dataResult;
    }
}
