package com.interview.multithreaded;

class VolatileWorker implements Runnable {

	private boolean isTerminated=false;

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

	@Override
	public void run() {
		while(!isTerminated) {
			System.out.println("Worker not finished");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
public class VolatileExample {
	
	public static void main(String[] args) {
		VolatileWorker worker = new VolatileWorker();
		Thread t = new Thread(worker);
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.setTerminated(true);
		
		System.out.println("Finished Main");
		
	}

}
