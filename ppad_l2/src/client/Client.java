package client;

import java.rmi.Naming;

import inter.InterfaceInfo;

public class Client {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try {
			InterfaceInfo server = (InterfaceInfo) Naming.lookup("//127.0.0.1:8080/myServer");
			System.out.println("Server response: " + server.getSomething("test"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}