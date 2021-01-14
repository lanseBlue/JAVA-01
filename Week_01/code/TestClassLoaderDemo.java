package com.geek.learn.week01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 运行自定义类加载器的测试类
 * @author 8
 */
public class TestClassLoaderDemo {

    public static void main(String[] args) {

        String path = "D:\\documents\\geek\\Hello.xlass";
        CustomerClassLoader customerClassLoader = new CustomerClassLoader(new CustomDecoderImpl(),path);
        try {
            Class<?> aClass = customerClassLoader.findClass("Hello");
            if(aClass ==null){
                return;
            }
            Object o = aClass.newInstance();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                declaredMethod.invoke(o);
            }


        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
