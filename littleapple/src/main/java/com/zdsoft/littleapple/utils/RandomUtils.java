package com.zdsoft.littleapple.utils;

/**
 * 生成随机函数
 *
 * @author fenglm
 */
public abstract class RandomUtils {
    /**
     * 产生固定长度的随机数字串。
     *
     * @param length 长度
     * @return 随机数字串
     */
    public static String getRandomNum(int length) {
        return (Double.toString(Math.random())).substring(2, (2 + length));
    }
}
