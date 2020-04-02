package com.jh.shiro.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author jh
 * @Date 2020/2/25
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResult {
    private Integer state;
    private Integer totalcount;
    private boolean success;
    private String message;
    private Object data;
    private List<? extends Object> result;
    private Map<? extends Object, ? extends Object> mapResult;
}
