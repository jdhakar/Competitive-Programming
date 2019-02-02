package com.interview.multithreaded;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantWorker {

	Lock lock = new ReentrantLock();
	Condition condition=lock.newCondition();

	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("Producer is up");
		condition.await();
		System.out.println("Producer completed");
		lock.unlock();
	}

	public void consumer() throws InterruptedException {
		Thread.sleep(5000);
		lock.lock();
		System.out.println("Consumer is up");
		condition.signal();
		lock.unlock();
	}
}

public class ReentrantLockExample {

	public static void main(String[] args) {

		ReentrantWorker worker = new ReentrantWorker();

		Thread t1 = new Thread( new Runnable() {

			@Override
			public void run() {
				try {
					worker.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread( new Runnable() {

			@Override
			public void run() {
				try {
					worker.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}

}
