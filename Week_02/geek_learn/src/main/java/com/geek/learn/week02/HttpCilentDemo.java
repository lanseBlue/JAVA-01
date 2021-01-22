package com.geek.learn.week02;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author 8
 */
public class HttpCilentDemo {

    public static void main(String[] args) {
        try(final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            //将参数与url拼接起来
            //String url = "http://localhost:8801";
            String url = "https://www.baidu.com";
            HttpGet httpGet = new HttpGet(url);
            //默认的连接服务器超时时间
            int defaultConnectTimeout = 3000;
            //默认的创建连接后，等待服务器响应的超时时间
            int defaultSocketTimeout = 10000;
            //默认的从连接池获取连接时的等待时间
            int defaultConnectionRequestTimeout = 10000;
            RequestConfig.Builder custom = RequestConfig.custom()
                    .setConnectTimeout(defaultConnectTimeout)
                    .setSocketTimeout(defaultSocketTimeout)
                    .setConnectionRequestTimeout(defaultConnectionRequestTimeout);
            httpGet.setConfig(custom.build());
            HttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String result= entity == null?"":readTheReturnedResult(entity);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将http请求的结果集转成字符串
     *
     * @param entity http请求结果对象
     * @return 字符串
     * @throws IOException io异常
     */
    public static String readTheReturnedResult(HttpEntity entity) throws IOException {
        try (InputStream inStream = entity.getContent();
             InputStreamReader inputStreamReader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            StringBuilder sb = new StringBuilder();
            // 文件处理方式
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }
}
