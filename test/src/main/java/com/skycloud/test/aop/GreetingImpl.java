/**
 * GreetingImpl.java
 */
package com.skycloud.test.aop;

/**
 * 
 * 
 * @creation 2013-9-17 上午10:00:52
 * @modification 2013-9-17 上午10:00:52
 * @company Skycloud
 * @author xiweicheng
 * @version 1.0
 * 
 */
public class GreetingImpl implements Greeting {

	@Override
	public void sayHello(String name) {

		System.out.println("GreetingImpl.sayHello() >> " + name);
	}

}
