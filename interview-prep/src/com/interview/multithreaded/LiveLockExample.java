package com.interview.multithreaded;

public class LiveLockExample {

	public static void main (String[] args) {
		final LiveLockWorker worker1 = new LiveLockWorker("Worker 1 ", true);
		final LiveLockWorker worker2 = new LiveLockWorker("Worker 2", true);

		final CommonResource s = new CommonResource(worker1);

		new Thread(() -> {
			worker1.work(s, worker2);
		}).start();

		new Thread(() -> {
			worker2.work(s, worker1);
		}).start();
	}

}

class CommonResource {
	private LiveLockWorker owner;

	public CommonResource (LiveLockWorker d) {
		owner = d;
	}

	public LiveLockWorker getOwner () {
		return owner;
	}

	public synchronized void setOwner (LiveLockWorker d) {
		owner = d;
	}
}

class LiveLockWorker {
	private String name;
	private boolean active;

	public LiveLockWorker (String name, boolean active) {
		this.name = name;
		this.active = active;
	}

	public String getName () {
		return name;
	}

	public boolean isActive () {
		return active;
	}

	public synchronized void work (CommonResource commonResource, LiveLockWorker otherWorker) {
		while (active) {
			// wait for the resource to become available.
			if (commonResource.getOwner() != this) {
				try {
					wait(10);
				} catch (InterruptedException e) {
					//ignore
				}
				continue;
			}

			// If other worker is also active let it do it's work first
			if (otherWorker.isActive()) {
				System.out.println(getName() + " : handing over the resource to the worker: " +
						otherWorker.getName());
				commonResource.setOwner(otherWorker);
				continue;
			}

			//now use the commonResource
			System.out.println(getName() + ": working on the common resource");
			active = false;
			commonResource.setOwner(otherWorker);
		}
	}
}