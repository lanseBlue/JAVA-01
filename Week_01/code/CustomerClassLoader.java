package com.geek.learn.week01;

import java.io.IOException;

/**
 * @author 8
 */
public class CustomerClassLoader extends ClassLoader {

    private CustomDecoder customDecoder;

    private String path;


    public CustomerClassLoader(CustomDecoder customDecoder,String path) {
        this.customDecoder = customDecoder;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = FileUtils.readBytes(path);
            byte[] decodeArray = customDecoder.decode(bytes);

            return defineClass(name, decodeArray, 0, decodeArray.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
