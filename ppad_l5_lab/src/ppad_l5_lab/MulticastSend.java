package ppad_l5_lab;

import java.net.*;
import java.io.*;

public class MulticastSend {
	public static void main(String[] args) throws Exception {
		InetAddress group = InetAddress.getByName("230.0.0.1");
		int port = 4446;
		byte[] buf = null;
		DatagramPacket packet = null;
		// se creeaza un socket pe un port oarecare
		DatagramSocket socket = new DatagramSocket();
		try {
			// trimite un pachet catre toti clientii din grup
			String s = new String("Hello there!");
			buf = s.getBytes();
			packet = new DatagramPacket(buf, buf.length, group, port);
			socket.send(packet);
		} finally {
			socket.close();
		}
	}
}
