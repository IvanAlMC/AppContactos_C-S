package controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerContacts {
	private final static int PORT = 23550;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public ServerContacts() throws IOException {
		serverSocket = new ServerSocket(PORT);
	}
	
	public void run() throws IOException{
		System.out.println("Este es el servidor");
		while(true) {
			clientSocket = serverSocket.accept();
			attend(this.clientSocket);
		}
	}
	
	public void attend(Socket clientSocket) throws IOException {
		new ClientThread(clientSocket).start();
	}
	
	public static void main(String[] args) throws IOException {
		new ServerContacts().run();
	}
}
