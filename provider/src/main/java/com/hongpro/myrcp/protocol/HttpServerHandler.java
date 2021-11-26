package com.hongpro.myrcp.protocol;

import com.hongpro.myrcp.registry.NativeRegistry;
import com.hongpro.myrcp.pojo.Invocation;
import com.hongpro.myrcp.pojo.URL;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/5/18 10:00
 */
public class HttpServerHandler {
    /**
     *  服务的处理
     * @param req
     * @param resp
     * @throws IOException
     */
    public void handle(HttpServletRequest req, HttpServletResponse resp){
        try {
            //服务请求的处理逻辑

            //1 通过请求流获取请求服务调用的参数
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) objectInputStream.readObject();
            System.out.println("invocation:" + invocation.toString());

            //2 从注册中心获取服务的列表
            Class implCass = NativeRegistry.get(invocation.getInterfaceName(), new URL("localhost", 8080));
            System.out.println("implClass:" + implCass.toString());

            //3 调用服务 反射
            Method method = implCass.getMethod(invocation.getMethodName(),invocation.getParamTypes());

            String result = (String) method.invoke(implCass.newInstance(), invocation.getParams());

            //4 结果返回
            IOUtils.write(result,resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
