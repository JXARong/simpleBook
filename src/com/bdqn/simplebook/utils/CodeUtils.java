package com.bdqn.simplebook.utils;

import jdk.nashorn.internal.ir.ReturnNode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.ClientInfoStatus;
import java.util.Random;

/**
 * @author: 赖榕
 * @date: 2019/11/2
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.utils
 */
public class CodeUtils {

    private static Random ran = new Random();


    public static String generateCode() {
        String vliCode = "";
        while (vliCode.length() < 4) {
            String tmp = "";
            switch (ran.nextInt(3)) {
                case 0:
                    tmp = (char) (ran.nextInt(26) + 65) + "";                //得到a-z的26字母
                    break;
                case 1:
                    tmp = (char) (ran.nextInt(26) + 97) + "";                //得到A-Z的26字母
                    break;
                default:
                    tmp = ran.nextInt(10) + "";                                //得到数字0-9
                    break;
            }
            vliCode += tmp;
        }
        return vliCode;
    }

    public static BufferedImage generateImage(String code) throws Exception {
        if (code.length() > 4) {
            throw new Exception("code.length()>4:" + code.length());
        }
        BufferedImage image = new BufferedImage(80, 35, BufferedImage.TYPE_3BYTE_BGR);
        Graphics gra = image.getGraphics();
        gra.setColor(Color.white);  // 设置图片颜色
        gra.setFont(new Font("微软雅黑", Font.ITALIC, 20));//设置字体
        gra.fillRect(0, 0, 80, 35);
        for (int i = 0; i < code.length(); i++) {
            gra.setColor(new Color(ran.nextInt(255) + 1, ran.nextInt(255) + 1, ran.nextInt(255) + 1));        //随机得到颜色用于绘制内容
            gra.drawString((String.valueOf(code.charAt(i))), 10 + i * 18, 20);        //此步为在x坐标为（10+vliCode.length()*20）y坐标为20的地方绘制内容为tmp的字符图。
        }
        // 绘制干扰线
        for (int i = 0; i < (ran.nextInt(5) + 5); i++) {
            gra.setColor(new Color(ran.nextInt(255) + 1, ran.nextInt(255) + 1, ran.nextInt(255) + 1));    //设置干扰线的颜色
            gra.drawLine(ran.nextInt(100), ran.nextInt(30), ran.nextInt(100), ran.nextInt(30));                //设置干扰线的坐标
        }
        return image;
    }

}
