package p2;

public class CustomThread extends Thread {
	private String character;
	
	public CustomThread(String character) {
		this.character = character;
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(this.character + i);
		}
	}
	

}
