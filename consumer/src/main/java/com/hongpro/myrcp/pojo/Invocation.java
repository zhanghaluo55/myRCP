package com.hongpro.myrcp.pojo;

import java.io.Serializable;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/5/18 10:09
 */
public class Invocation implements Serializable {
    private static final long serialVersionUID = 7947829854508732723L;
    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class[] paramTypes;

    public Invocation(String interfaceName, String methodName, Object[] params, Class[] paramTypes) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.params = params;
        this.paramTypes = paramTypes;
    }

    public Invocation() {
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }
}
