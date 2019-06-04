package com.jyx.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2019-06-04 15:08
 **/
public class ProxyHandler implements InvocationHandler{
    private Object subject;

    public ProxyHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(subject, args);
        return null;
    }
}
