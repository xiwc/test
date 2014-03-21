package com.skycloud.test.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibDynamicProxy2 implements MethodInterceptor {

    private static CGLibDynamicProxy2 instance = new CGLibDynamicProxy2();

    private CGLibDynamicProxy2() {
    }

    public static CGLibDynamicProxy2 getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(target, args);
        after();
        return result;
    }

    private void before() {
    	System.out.println("CGLibDynamicProxy2.before()");
    }

    private void after() {
    	System.out.println("CGLibDynamicProxy2.after()");
    }
}