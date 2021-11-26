package com.hongpro.myrcp.provider;

import com.hongpro.myrcp.registry.NativeRegistry;
import com.hongpro.myrcp.protocol.HttpServer;
import com.hongpro.myrcp.service.HelloService;
import com.hongpro.myrcp.service.impl.HelloServiceImpl;
import com.hongpro.myrcp.pojo.URL;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/5/17 18:27
 */
public class ServiceProvider {
    public static void main(String[] args) {
        URL url = new URL("localhost", 8080);
        //服务注册
        NativeRegistry.registry(HelloService.class.getName(), url, HelloServiceImpl.class);

        //启动tomcat,暴露服务
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());

    }
}
