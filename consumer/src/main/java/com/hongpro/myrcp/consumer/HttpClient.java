package com.hongpro.myrcp.consumer;

import com.hongpro.myrcp.pojo.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/5/18 10:24
 */
public class HttpClient {
    public String post(String hostName, int port, Invocation invocation) throws IOException {
        try {
            URL url = new URL("http", hostName, port, "/client/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);// 必填项

            //发送调用的信息
            OutputStream os = connection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            // 将输入流转为字符串（此处可是java对象） 获取远程调用的结果
            InputStream is = connection.getInputStream();
            return IOUtils.toString(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
