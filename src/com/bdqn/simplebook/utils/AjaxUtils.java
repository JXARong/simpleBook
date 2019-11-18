package com.bdqn.simplebook.utils;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description: ajax响应工具类
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.utils
 */
public class AjaxUtils {
    private boolean flag;//后端返回结果正常为true，发生异常返回false
    private Object data;//后端返回结果数据对象
    private String errorMsg;//发生异常的错误消息
    private String msg; // 正常信息

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
