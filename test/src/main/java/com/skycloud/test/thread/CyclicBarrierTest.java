package com.skycloud.test.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		float[][] matrix = new float[5][3];
		new Solver(matrix);
	}

}

class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;

	class Worker implements Runnable {
		int myRow;

		Worker(int row) {
			myRow = row;
		}

		public void run() {
			boolean done = false;
			while (!done) {

				System.out.println("processRow(myRow);");

				done = true;

				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException ex) {
					return;
				}
			}
		}
	}

	public Solver(float[][] matrix) {

		data = matrix;
		N = matrix.length;

		barrier = new CyclicBarrier(N + 1, new Runnable() {
			public void run() {
				System.out.println("mergeRows(...);");
			}
		});
		for (int i = 0; i < N; ++i)
			new Thread(new Worker(i)).start();

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException ex) {
			return;
		}

		System.out.println("waitUntilDone();");
	}
}