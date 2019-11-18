package com.bdqn.simplebook.utils;

import java.util.Random;

/**
 * @author: 赖榕
 * @date: 2019/11/18
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.utils
 */
public class NumberUtils {

    public  static String createRandomNumber(int len){
        int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, len - 1));
        return String.valueOf(rs);
    }

}
