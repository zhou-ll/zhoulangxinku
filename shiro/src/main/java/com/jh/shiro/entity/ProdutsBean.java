/**
 * @title :  ProdutsBean.java
 * @author: jianghua
 * @create: 2020/3/27 21:50
 * @modify:
 * @description : 商品Bean
 * @version: 1.0
 */
package com.jh.shiro.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @description：商品Bean
 * @author: jianghua
 * @version: 1.0
 * @date: 2020/3/27 21:50
 */
@Data
@Entity
@Table(name = "produts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutsBean {
    /**
     * 唯一id
     * PS：@GeneratedValue注解的strategy属性提供四种值：
     * 1.AUTO： 主键由程序控制，是默认选项，不设置即此项。
     * 2.IDENTITY：(mysql主用)主键由数据库自动生成，即采用数据库ID自增长的方式，Oracle不支持这种方式。
     * 3.SEQUENCE：通过数据库的序列产生主键，通过@SequenceGenerator 注解指定序列名，mysql不支持这种方式。
     * 4.TABLE：通过特定的数据库表产生主键，使用该策略可以使应用更易于数据库移植。
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "TestSequence")
    @SequenceGenerator(name = "TestSequence", sequenceName = "newid", allocationSize=1)
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private BigDecimal price;
}
