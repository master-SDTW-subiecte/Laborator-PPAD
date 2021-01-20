package p1;

public class CustomThread extends Thread {
	private Boolean flag = true;

	@Override
	public void run() {
		while(flag) {
			System.out.println("Running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}
