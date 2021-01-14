package com.geek.learn.week01;

/**
 * @author 8
 */
public interface CustomDecoder {

    /**
     * 将byte数组按照一定规则解码
     * @param bytes 原始的byte数组
     * @return 解码后的byte数组
     */
     byte[] decode(byte[] bytes);
}
