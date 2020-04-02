package com.shenyue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shenyue.entity.student;

/**
*@packgeName	com.shenyue.mapper
*@author	zhoulanglang
*@version	2019年6月21日下午8:31:27
*
*/
@Mapper
public interface StuMapper {
	List<student> selectAll();
	int insertByOne(student stu);
	int updateById(student stu);
}
