package com.geek.learn.week01;

/**
 * @author 8
 */
public class CustomDecoderImpl implements CustomDecoder {

    @Override
    public byte[] decode(byte[] bytes) {
        byte[] decodeByte = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            int byteResult = 255 - bytes[i];
            decodeByte[i] = (byte) byteResult;
        }
        return decodeByte;
    }
}
