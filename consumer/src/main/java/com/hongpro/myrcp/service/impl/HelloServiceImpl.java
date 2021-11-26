package com.hongpro.myrcp.service.impl;


import com.hongpro.myrcp.service.HelloService;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/5/17 18:10
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + "调用了服务";
    }
}
