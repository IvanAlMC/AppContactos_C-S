package controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import views.View;

public class Client {
	private final static String HOST = "186.114.217.181";
	private final static int PORT = 23550;
	private Socket socket;
	private View view;
	
	public Client() throws UnknownHostException, IOException {
		socket = new Socket(HOST, PORT);
		view = new View();
	}
	
	public void run() throws IOException {
		System.out.println("Este es el cliente");
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		DataInputStream input = new DataInputStream(socket.getInputStream());
		output.writeUTF("Saludos desde el cliente");
		boolean exit = false;
		do {
			System.out.println("Que tipo de operacion quieres");
			view.showMenu();
			int option = view.getOption();
			output.write(option);
			if(option == 1) {
				String name = view.getName();
				output.writeUTF(name);
				long number = view.getNumber();
				output.writeLong(number);
				String email = view.getEmail();
				output.writeUTF(email);
			}else if(option == 2) {
				String name = view.getName();
				output.writeUTF(name);
				String contact = input.readUTF();
				view.showInformationContact(contact);
			}else if(option == 3) {
				String name = view.getName();
				output.writeUTF(name);
			}else if(option == 4) {
				String list = input.readUTF();
				view.showContacts(list);
			}else if(option == 5) {
				String first = input.readUTF();
				String last = input.readUTF();
				int quantity = input.read();
				view.showFirst(first);
				view.showLast(last);
				view.showQuantity(quantity);
			}else if(option == 6) {
				view.showMessageFinish();
				exit = true;
			}else {
				view.showMessageInvalidOption();
			}
		}while(!exit);
		socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().run();
	}
}
