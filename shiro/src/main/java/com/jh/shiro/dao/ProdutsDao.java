/**
 * @title :  ProdutsDao.java
 * @author: jianghua
 * @create: 2020/3/27 21:55
 * @modify:
 * @description : 商品Dao
 * @version: 1.0
 */
package com.jh.shiro.dao;

/**
 * @description：商品Dao
 * @author: jianghua
 * @version: 1.0
 * @date: 2020/3/27 21:56
 */

import com.jh.shiro.entity.ProdutsBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutsDao extends JpaRepository<ProdutsBean, Integer> {

    /**
     * 根据商品名称查询商品
     *
     * @param produtsName
     * @return
     */
    @Select("select count(id) cnt from produts where name like #{produtsName}")
    List<ProdutsBean> queryProdutsInfoByName(@Param("produtsName") String produtsName);
}
