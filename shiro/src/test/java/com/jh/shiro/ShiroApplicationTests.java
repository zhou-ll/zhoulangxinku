package com.jh.shiro;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jh.shiro.entity.TeacherEntity;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ShiroApplicationTests {

    @Test
    void contextLoads() {
        TeacherEntity entity = new TeacherEntity(1,"张三",BigDecimal.valueOf(10000));
        JSONObject obj = (JSONObject) JSONArray.toJSON(entity);
        System.out.println(obj);
    }

}
