package server.server1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import inter.InterfaceInfo;

public class Server implements InterfaceInfo {
	public String getSomething(String str) throws RemoteException {
		return "!!! " +str+" !!!";
	}
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try{
			Server server=new Server();
			InterfaceInfo stub=(InterfaceInfo)UnicastRemoteObject.exportObject(server,0);
			Naming.rebind("//127.0.0.1:8080/myServer", stub);
			System.out.println("Stub bound...");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Server running");
	}
}
