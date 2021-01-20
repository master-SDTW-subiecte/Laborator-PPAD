package server.server2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import inter.InterfaceInfo;

@SuppressWarnings("serial")
public class Server extends UnicastRemoteObject implements InterfaceInfo {
	public Server(int port) throws RemoteException {
		super(port);
	}

	public String getSomething(String str) throws RemoteException {
		return "!!! " + str + " !!!";
	}

	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try {
			Registry localreg = LocateRegistry.createRegistry(8080);
			Server server = new Server(8080);
			localreg.rebind("myServer", server);
			System.out.println("Stub bound...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Server running...");
	}
}
