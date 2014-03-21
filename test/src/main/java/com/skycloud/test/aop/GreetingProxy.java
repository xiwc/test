/**
 * GreetingProxy.java
 */
package com.skycloud.test.aop;

/**
 * 
 * 
 * @creation 2013-9-17 上午10:02:56
 * @modification 2013-9-17 上午10:02:56
 * @company Skycloud
 * @author xiweicheng
 * @version 1.0
 *
 */
public class GreetingProxy implements Greeting {
	
	private GreetingImpl greetingImpl;

	public GreetingProxy(GreetingImpl greetingImpl) {
		super();
		this.greetingImpl = greetingImpl;
	}

	/*
	 * @see com.sky.xwc.aop.Greeting#sayHello(java.lang.String)
	 */
	@Override
	public void sayHello(String name) {
		
		before();
		
		greetingImpl.sayHello(name);
		
		after();
		

	}
	

	private void before() {

		System.out.println("Before");

	}

	private void after() {

		System.out.println("After");

	}

}
