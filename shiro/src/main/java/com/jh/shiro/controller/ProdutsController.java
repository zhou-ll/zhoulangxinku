/**
 * @title :  ProdutsController.java
 * @author: jianghua
 * @create: 2020/3/27 22:28
 * @modify:
 * @description : 商品Controller
 * @version: 1.0
 */
package com.jh.shiro.controller;

import com.jh.shiro.entity.ProdutsBean;
import com.jh.shiro.service.ProdutsService;
import com.jh.shiro.service.impl.ProdutsServiceImpl;
import com.jh.shiro.util.Result;
import com.jh.shiro.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description：商品Controller
 * @author: jianghua
 * @version: 1.0
 * @date: 2020/3/27 22:28
 */
@Slf4j
@CrossOrigin
@RestController
public class ProdutsController {

    @Resource
    private ProdutsService produtsService;

    /**
     * 增
     * @param produtsBean
     * @return: com.jh.shiro.util.Result
     */
    @PostMapping("shiro/saveProdutsInfo")
    public Result saveProdutsInfo(@RequestBody ProdutsBean produtsBean) {
        Result result;
        try {
            result = produtsService.add(produtsBean);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 删
     * @param produtsBean
     * @return: com.jh.shiro.util.Result
     */
    @PostMapping("shiro/deleteProdutsInfo")
    public Result deleteProdutsInfo(@RequestBody ProdutsBean produtsBean) {
        Result result;
        try {
            result = produtsService.add(produtsBean);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 改
     * @param produtsBean
     * @return: com.jh.shiro.util.Result
     */
    @PostMapping("shiro/updateProdutsInfo")
    public Result updateProdutsInfo(@RequestBody ProdutsBean produtsBean) {
        Result result;
        try {
            result = produtsService.add(produtsBean);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 查
     * @param produtsBean
     * @return: com.jh.shiro.util.Result
     */
    @PostMapping("shiro/queryProdutsInfo")
    public Result queryProdutsInfo(@RequestBody ProdutsBean produtsBean) {
        Result result;
        try {
            result = produtsService.add(produtsBean);
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    /**
     * 查所有
     * @return: com.jh.shiro.util.Result
     */
    @PostMapping("shiro/listProdutsInfo")
    public Result listProdutsInfo() {
        Result result;
        try {
            result = produtsService.list();
        } catch (Exception e) {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }
}
