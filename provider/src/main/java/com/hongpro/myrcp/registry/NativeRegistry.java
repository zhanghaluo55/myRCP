package com.hongpro.myrcp.registry;

import com.hongpro.myrcp.pojo.URL;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/5/17 18:19
 */
public class NativeRegistry {
    private static Map<String, Map<URL, Class>> registryCenter = new HashMap<>();

    /**
     * 注册服务
     */
    public static void registry(String interfaceName, URL url, Class implClass) {
        Map<URL, Class> map = new HashMap<>();
        map.put(url, implClass);
        registryCenter.put(interfaceName, map);

        System.out.println("registry");
        for (Map.Entry<String, Map<URL, Class>> entry : registryCenter.entrySet()) {
            String key = entry.getKey();
            System.out.println("map interfaceName:" + key);
            Map<URL, Class> value = entry.getValue();
            for (Map.Entry<URL, Class> entry1 : value.entrySet()) {
                URL key1 = entry1.getKey();
                System.out.println("map URL:" + key1.toString());
                System.out.println("map impl: " + entry1.getValue());
            }
        }
    }

    /**
     * 获取服务信息
     */
    public static Class get(String interfaceName, URL url) {
        System.out.println("get intergaceName: " + interfaceName);
        System.out.println("get url :" + url.toString());

        System.out.println("get");
        for (Map.Entry<String, Map<URL, Class>> entry : registryCenter.entrySet()) {
            String key = entry.getKey();
            System.out.println("map interfaceName:" + key);
            Map<URL, Class> value = entry.getValue();
            for (Map.Entry<URL, Class> entry1 : value.entrySet()) {
                URL key1 = entry1.getKey();
                System.out.println("map URL:" + key1.toString());
                System.out.println("map impl: " + entry1.getValue());
            }
        }

        Map<URL, Class> urlClassMap = registryCenter.get(interfaceName);
        Class clzz = urlClassMap.get(url);
        return clzz;
    }
}
