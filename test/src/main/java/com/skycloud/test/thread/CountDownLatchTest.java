package com.skycloud.test.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest { // ...

	public static void main(String[] args) throws InterruptedException {
		new CountDownLatchTest().test();
	}

	void test() throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(10);

		for (int i = 0; i < 10; ++i)
			// create and start threads
			new Thread(new Worker(startSignal, doneSignal, "Thread-" + i)).start();

		// doSomethingElse(); // don't let run yet
		System.out.println("123");

		startSignal.countDown(); // let all threads proceed
		// doSomethingElse();
		System.out.println("456");

		doneSignal.await(); // wait for all to finish
		System.out.println("789");
	}
}

class Worker implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;
	private String name;

	Worker(CountDownLatch startSignal, CountDownLatch doneSignal, String name) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
		this.name = name;
	}

	public void run() {
		try {
			startSignal.await();
			doWork();
			doneSignal.countDown();
		} catch (InterruptedException ex) {
		} // return;
	}

	void doWork() {
		System.out.println("Worker.doWork() " + name);
	}
}