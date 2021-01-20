package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable {
	private Socket client;

	public ServerHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			String received = null;
			while (!("close".equals(received = in.readLine()))) {
				System.out.println(Thread.currentThread().getName() + ": " + received);
				out.println("Echo: " + received);
				out.flush();
			}
			System.out.println(Thread.currentThread().getName() + ": Done");
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
