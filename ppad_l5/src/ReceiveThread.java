

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReceiveThread extends Thread {

	private static final int SIZE = 256;
	private Map<String, Long> topology;
	private InetAddress group;
	private int port;

	public ReceiveThread(InetAddress group, int port) {
		this.group = group;
		this.port = port;
		this.topology = new ConcurrentHashMap<>();
	}

	public void run() {
		MulticastSocket socket = null;
		byte[] content = new byte[SIZE];

		try {
			socket = new MulticastSocket(port);
			socket.joinGroup(group);

			DatagramPacket packet = new DatagramPacket(content, content.length);

			while (true) {
				socket.receive(packet);
				String s = new String(packet.getData(), packet.getOffset(),
						packet.getLength());
				
				topology.put(s, System.currentTimeMillis());
				updateTopology();
				
				System.out.println(topology);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.leaveGroup(group);
			} catch (IOException e) {
				e.printStackTrace();
			}
			socket.close();
		}
	}
	
	public void updateTopology() {
		for (Map.Entry<String, Long> entry : this.topology.entrySet())
		{
		    if(System.currentTimeMillis() - entry.getValue() > 10000)
		    {
		    	this.topology.remove(entry.getKey());
		    }
		}
	}
}
