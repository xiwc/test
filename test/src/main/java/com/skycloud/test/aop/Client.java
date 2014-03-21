package com.skycloud.test.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// new GreetingProxy(new GreetingImpl()).sayHello("name");

		// Greeting greeting = new JDKDynamicProxy(new
		// GreetingImpl()).GetProxy();
		//
		// greeting.sayHello("name");

		// Greeting greeting =
		// CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
		// greeting.sayHello("Jack");

		Greeting greeting2 = (Greeting) Enhancer.create(GreetingImpl.class, new Class[] { Greeting.class },
				new CallbackFilter() {
					@Override
					public int accept(Method method) {
						return 1;
					}
				}, new Callback[] { CGLibDynamicProxy.getInstance(), CGLibDynamicProxy2.getInstance() });


		greeting2.sayHello("xiwc");
	}
}
