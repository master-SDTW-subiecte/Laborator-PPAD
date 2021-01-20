package p3;

public class Producer extends Thread {
	private Resource res;

	public Producer(Resource r) {
		this.res = r;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				res.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
