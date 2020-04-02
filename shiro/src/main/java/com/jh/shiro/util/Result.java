package com.jh.shiro.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 数据响应Bean
 *
 * @author: jh
 * @date: 2020/3/13
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回结果集
     */
    private List<? extends Object> list;

    /**
     * 初始化公共的返回码
     *
     * @param
     * @return
     */
    public Result(ResultCode resultCode) {
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
    }

    /**
     * 初始化公共的返回码
     *
     * @param
     * @return
     */
    public Result(ResultCode resultCode, Object data) {
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
        this.data = data;
    }

    /**
     * 初始化公共的返回码
     *
     * @param
     * @return
     */
    public Result(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

//    public static Result SUCCESS(){
//        return new ResultCode(ResultCode.SUCCESS);
//    }
//
//    public static Result ERROR(){
//        return new ResultCode(ResultCode.SAVE_ERROR);
//    }
//
//    public static Result FAIL(){
//        return new ResultCode(ResultCode.FAIL);
//    }
}
