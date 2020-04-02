/**
 * @title :  Produts.java
 * @author: jianghua
 * @create: 2020/3/27 22:13
 * @modify:
 * @description : 商品Service
 * @version: 1.0
 */
package com.jh.shiro.service;

import com.jh.shiro.entity.ProdutsBean;

/**
 * @description：商品Service
 * @author: jianghua
 * @version: 1.0
 * @date: 2020/3/27 22:13
 */
public interface ProdutsService extends CommonService<ProdutsBean> {
    int queryProdutsInfoByName(String produtsName);
}
