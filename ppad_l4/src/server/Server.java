package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
	ThreadPoolExecutor threadPoolExecutor;
	ServerSocket serverSocket;

	public Server(int portNumber) throws IOException {
		serverSocket = new ServerSocket(portNumber);
		threadPoolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
	}

	public void run() throws IOException {
		while (true) {
			Socket clientSocket = serverSocket.accept();
			threadPoolExecutor.execute(new ServerHandler(clientSocket));
		}
	}

	public static void main(String[] args) throws IOException {
		Server server = new Server(8087);
		server.run();
	}
}
