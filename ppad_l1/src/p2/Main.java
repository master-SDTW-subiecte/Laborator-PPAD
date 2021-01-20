package p2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomThread t0 = new CustomThread("0");
		CustomThread tx = new CustomThread("x");
		
		t0.setPriority(Thread.MAX_PRIORITY);
		
		t0.start();
		tx.start();
	}

}
