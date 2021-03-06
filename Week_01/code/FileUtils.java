package com.geek.learn.week01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 8
 */
public class FileUtils {

    public static byte[] readBytes(String path) throws IOException {

        File file = new File(path);
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            return toByteArray(fileInputStream);
        }
    }

    private static byte[] toByteArray(InputStream in) throws IOException {

       try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
           byte[] buffer = new byte[1024 * 4];
           int n = 0;
           while ((n = in.read(buffer)) != -1) {
               out.write(buffer, 0, n);
           }
           return out.toByteArray();
       }

    }

    }
