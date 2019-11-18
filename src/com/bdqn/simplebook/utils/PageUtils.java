package com.bdqn.simplebook.utils;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description: 分页工具类
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.utils
 */
public class PageUtils {

    private Integer code; // 状态
    private String msg;  // 分页携带的信息
    private Integer count; // 总页数
    private List<?> data; // 数据

    public PageUtils(Integer code, String msg, Integer count, List<?> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public PageUtils() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
