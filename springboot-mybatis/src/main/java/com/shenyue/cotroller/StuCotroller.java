package com.shenyue.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shenyue.entity.student;
import com.shenyue.services.StuService;

/**
 * @packgeName com.shenyue.cotroller
 * @author zhoulanglang
 * @version 2019年6月21日下午8:42:42
 *
 */
@RestController
@RequestMapping("/Stu")
public class StuCotroller {
	@Autowired
	StuService Stuservice;

	@GetMapping("/selectAll")
	@ResponseBody
	public List<student> select() {
		return Stuservice.selectAll();
	}
	
	@GetMapping("/insertByOne")
	public int Insert(student stu) {
		stu.setId(2);
		stu.setName("注释");
		stu.setAge(23);
		stu.setAddress("上海");
		return Stuservice.insert(stu);
	}
	
	@GetMapping("/updateById")
	public int updateById(student stu) {
		return Stuservice.updateById(stu);
	}

}
