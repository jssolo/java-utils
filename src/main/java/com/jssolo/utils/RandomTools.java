package com.jssolo.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 获取随机字符工具
 */
public class RandomTools {

    /**
     * 获取指定长度的随机数(正整数)
     * 第一位数生成范围为1-9，不会出现0开头的数字
     * @author ZYan
     * @param length 指定长度 区间为1-9
     * @return 返回指定长度的随机数
     */
    public static Integer getPositiveInt(Integer length){
        if(length > 9 || length < 1){
            throw new IllegalArgumentException("length必须为1到9之间的整数，但是得到" + length);
        }
        StringBuffer s = new StringBuffer();
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 10);
        s.append(randomNumber);
        for (int i = 1; i < length; i++){
            int temp = ThreadLocalRandom.current().nextInt(0, 10);
            s.append(temp);
        }
        return Integer.valueOf(s.toString());
    }

    /**
     * 获取指定长度的随机数
     * @author ZYan
     * @param length 指定长度 区间为1-9
     * @return 返回指定长度的随机数
     */
    public static String getNum(Integer length){
        if(length > 9 || length < 1){
            throw new IllegalArgumentException("length必须为1到9之间的整数，但是得到" + length);
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < length; i++){
            int temp = ThreadLocalRandom.current().nextInt(0, 10);
            s.append(temp);
        }
        return s.toString();
    }

    /**
     * 获取指定长度的随机小写字符
     * @author ZYan
     * @param length 指定长度 区间为1-99
     * @return 返回指定长度的随机小写字符
     */
    public static String getChara(Integer length){
        if(length > 99 || length < 1){
            throw new IllegalArgumentException("length必须为1到99之间的整数，但是得到" + length);
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < length; i++){
            char temp = (char) ((int) (Math.random() * 26) + 'a');
            s.append(temp);
        }
        return s.toString();
    }

    /**
     * 获取指定长度的随机大写字符
     * @author ZYan
     * @param length 指定长度 区间为1-99
     * @return 返回指定长度的随机大写字符
     */
    public static String getCharA(Integer length){
        if(length > 99 || length < 1){
            throw new IllegalArgumentException("length必须为1到99之间的整数，但是得到" + length);
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < length; i++){
            char temp = (char) ((int) (Math.random() * 26) + 'A');
            s.append(temp);
        }
        return s.toString();
    }

    /**
     * 获取指定长度的随机字符,其中包括大写和小写
     * @author ZYan
     * @param length 指定长度 区间为1-99
     * @return 返回指定长度的随机字符
     */
    public static String getChar(Integer length){
        if(length > 99 || length < 1){
            throw new IllegalArgumentException("length必须为1到99之间的整数，但是得到" + length);
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < length; i++){
            int t = ThreadLocalRandom.current().nextInt(1, 10);
            if(t > 5){
                char temp = (char) ((int) (Math.random() * 26) + 'a');
                s.append(temp);
            }else{
                char temp = (char) ((int) (Math.random() * 26) + 'A');
                s.append(temp);
            }
        }
        return s.toString();
    }

    /**
     * 获取指定长度的随机字符,其中包括大写和小写以及数字
     * @author ZYan
     * @param length 指定长度 区间为1-99
     * @return 返回指定长度的随机字符
     */
    public static String getCharNum(Integer length){
        if(length > 99 || length < 1){
            throw new IllegalArgumentException("length必须为1到99之间的整数，但是得到" + length);
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < length; i++){
            int t = ThreadLocalRandom.current().nextInt(1, 10);
            if(t >= 1 && t <= 3){
                char temp = (char) ((int) (Math.random() * 26) + 'a');
                s.append(temp);
            }else if(t >= 4 && t <= 6){
                char temp = (char) ((int) (Math.random() * 26) + 'A');
                s.append(temp);
            }else{
                int temp = ThreadLocalRandom.current().nextInt(0, 10);
                s.append(temp);
            }
        }
        return s.toString();
    }

}
