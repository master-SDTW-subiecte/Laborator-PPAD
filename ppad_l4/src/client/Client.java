package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private BufferedReader br;
	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 8087);
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	}

	public void run() throws IOException {
		while (true) {
			System.out.println("Write:");
			out.println(br.readLine());
			out.flush();
			String received = in.readLine();
			if (received == null) {
				break;
			} else {
				System.out.println("Received: " + received);
			}
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.run();
	}
}
