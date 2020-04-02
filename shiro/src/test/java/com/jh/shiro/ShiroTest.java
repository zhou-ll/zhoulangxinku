package com.jh.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jh.shiro.entity.TeacherEntity;
import org.junit.Test;

import java.math.BigDecimal;

public class ShiroTest {
    @Test
    public void contextLoads() {
        TeacherEntity entity = new TeacherEntity(1,"张三", BigDecimal.valueOf(10000));
        JSONObject obj = (JSONObject) JSON.toJSON(entity);
        System.out.println(obj);
    }
}
