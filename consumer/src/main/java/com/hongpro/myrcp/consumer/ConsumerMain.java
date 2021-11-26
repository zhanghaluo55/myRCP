package com.hongpro.myrcp.consumer;

import com.hongpro.myrcp.pojo.Invocation;
import com.hongpro.myrcp.service.HelloService;

import java.io.IOException;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/5/18 10:33
 */
public class ConsumerMain {
    public static void main(String[] args) throws IOException {
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Object[]{"myRPC客户端"}, new Class[]{String.class});

        String result = new HttpClient().post("localhost", 8080, invocation);
        System.out.println(result);
    }
}
