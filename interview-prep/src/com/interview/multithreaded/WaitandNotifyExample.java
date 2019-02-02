package com.interview.multithreaded;

class WandNWorker {
	public void producer() {
		synchronized (this) {
			System.out.println("Producer is up");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Producer completed");
		}
	}

	public void consumer() {
		synchronized (this) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumer is up");
			notify();
		}
	}
}

public class WaitandNotifyExample {
	static WandNWorker worker = new WandNWorker();

	public static void main(String[] args) {

		Thread t1 = new Thread( new Runnable() {

			@Override
			public void run() {
				worker.producer();
			}
		});

		Thread t2 = new Thread( new Runnable() {

			@Override
			public void run() {
				worker.consumer();
			}
		});

		t1.start();
		t2.start();
	}

}
