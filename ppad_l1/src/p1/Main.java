package p1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CustomThread ct1 = new CustomThread();
		//CustomThread ct2 = new CustomThread();
		System.out.println(ct1.getState());
		ct1.start();
		System.out.println(ct1.getState());
		//while(ct1.isAlive()) {
			Thread.sleep(3000);
			ct1.setFlag(false);
		//}
		System.out.println(ct1.getState());
	}

}
