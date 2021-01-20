

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendThread extends Thread {
	private static final int DELAY = 10000;
	
	private InetAddress group;
	private int port;
	private String name;

	public SendThread(String name, InetAddress group, int port) {
		this.name = name;
		this.group = group;
		this.port = port;
	}

	public void run() {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}

		byte[] content = null;
		DatagramPacket packet = null;
		content = name.getBytes();
		packet = new DatagramPacket(content, content.length, group, port);
		try {
			while (true) {
				
				
				socket.send(packet);
				Thread.sleep(DELAY);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}
}
