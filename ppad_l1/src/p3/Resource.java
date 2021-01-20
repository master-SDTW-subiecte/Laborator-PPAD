package p3;

public class Resource {
	int x = -1;

	public synchronized void put(int value) throws InterruptedException {
		if (x != -1) {
			wait();
		}
		
		x = value;
		System.out.println(Thread.currentThread() + " produced: " + this.x);
		notify();
	}

	public synchronized int get() throws InterruptedException {
		if (x == -1) {
			wait();
		}
		System.out.println(Thread.currentThread() + " consumed: " + this.x);
		int y = x;
		x = -1;
		notify();
		return y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r = new Resource();
		Producer p = new Producer(r);
		Consumer c = new Consumer(r);
		p.start();
		c.start();
	}
}
