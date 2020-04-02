package com.shenyue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shenyue.entity.student;
import com.shenyue.mapper.StuMapper;

/**
 * @packgeName com.shenyue.services
 * @author zhoulanglang
 * @version 2019年6月21日下午8:36:20
 *
 */
@Service
public class StuService {
	@Autowired
	private StuMapper StuDao;

	public List<student> selectAll() {
		return StuDao.selectAll();
	}
	
	public int insert(student stu){
		return StuDao.insertByOne(stu);
	}
	
	@Transactional	//开启事务
	//根据主键更新
	public int updateById(student stu) {
		stu.setId(1);
		stu.setAge(22222222);
		stu.setName("周77");
		int update=StuDao.updateById(stu);
		//int i=10/0;//运行时错误
		return update;
	}
}
