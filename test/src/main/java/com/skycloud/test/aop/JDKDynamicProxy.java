/**
 * JDKDynamicProxy.java
 */
package com.skycloud.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * 
 * @creation 2013-9-17 上午11:04:14
 * @modification 2013-9-17 上午11:04:14
 * @company Skycloud
 * @author xiweicheng
 * @version 1.0
 * 
 */
public class JDKDynamicProxy implements InvocationHandler {

	private Object target;

	public JDKDynamicProxy(Object target) {
		this.target = target;
	}

	@SuppressWarnings("unchecked")
	public <T> T GetProxy() {

		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		before();
		
		Object result = method.invoke(target, args);
		
		after();
		
		return result;
	}
	
	private void before() {

		System.out.println("Before");

	}

	private void after() {

		System.out.println("After");

	}

}
