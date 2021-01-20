package ppad_l5_lab;

import java.net.*;
import java.io.*;

public class MulticastClient {
	public static void main(String[] args) throws IOException {
		// adresa IP si portul care reprezinta grupul de clienti
		InetAddress group = InetAddress.getByName("230.0.0.1");
		int port = 4446;
		MulticastSocket socket = null;
		byte[] buf = null;
		try {
			// se alatura grupului aflat la adresa si portul specificate
			socket = new MulticastSocket(port);
			System.out.println("Loopback mode disabled: " + socket.getLoopbackMode());
			socket.joinGroup(group);
			// se asteapta un pachet venit pe adresa grupului
			buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			// se afiseaza continutul pachetului
			String s = new String(packet.getData(), packet.getOffset(), packet.getLength());
			System.out.println(s);
		} finally {
			socket.leaveGroup(group);
			socket.close();
		}
	}
}