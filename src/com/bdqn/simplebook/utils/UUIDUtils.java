package com.bdqn.simplebook.utils;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.UUID;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.utils
 */
public class UUIDUtils {
    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
