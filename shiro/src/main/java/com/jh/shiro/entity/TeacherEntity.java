package com.jh.shiro.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 教师Bean
 *
 * @author: jh
 * @date: 2020/3/14
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherEntity {
    private Integer id;
    private String name;
    private BigDecimal salary;
}
