/**
 * @title :  ResultCode.java
 * @author: jianghua
 * @create: 2020/3/27 21:57
 * @modify:
 * @description : 返回消息工具类
 * @version: 1.0
 */
package com.jh.shiro.util;

/**
 * @description：返回消息工具类
 * @author: jianghua
 * @version: 1.0
 * @date: 2020/3/27 21:57
 */
public enum ResultCode {
    /**
     * 登录成功
     */
    LOGINSUCCESS(true, 200, "登录成功"),
    /**
     * 操作成功
     */
    SUCCESS(true, 200, "操作成功"),
    /**
     * 操作失败
     */
    FAIL(false, 500, "操作失败"),
    /**
     * 您还未登录
     */
    UNAUTHENTICATION(false, 10001, "您还未登录"),
    /**
     * 权限不足
     */
    UNAUTHORISE(false, 10003, "权限不足"),
    /**
     * 抱歉，系统繁忙，请稍后再试
     */
    SAVE_ERROR(false, 99999, "抱歉，系统繁忙，请稍后再试");
    /**
     * 操作是否成功
     */
    Boolean success;
    /**
     * 操作代码
     */
    Integer code;
    /**
     * 提示信息
     */
    String message;

    /**
     * 初始化公共的返回码
     *
     * @param success
     * @param code
     * @param message
     * @return
     */
    ResultCode(boolean success, int code, String message) {
        this.init(success, code, message);
    }

    /**
     * 初始化方法
     *
     * @param success
     * @param code
     * @param message
     * @return void
     */
    void init(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
