package p3;

public class Consumer extends Thread {
	private Resource res;

	public Consumer(Resource r) {
		this.res = r;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				res.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
