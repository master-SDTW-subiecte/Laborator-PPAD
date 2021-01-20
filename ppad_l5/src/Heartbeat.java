import java.net.InetAddress;
import java.net.UnknownHostException;

public class Heartbeat {
	private static final int PORT = 3333;

	public static void main(String[] args) throws UnknownHostException {
		InetAddress group = InetAddress.getByName("224.0.0.1");;
		
		ReceiveThread receiveThread = new ReceiveThread(group, PORT);
		receiveThread.start();
		
		SendThread sendThread = new SendThread(args[0],group, PORT);
		sendThread.start();
	}
}
