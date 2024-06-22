package controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import models.ContactsList;

public class ClientThread extends Thread{
	
	private Socket clientSocket;
	private ContactsList contacts;
	
	public ClientThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		contacts = new ContactsList();
	}
	
	public void run(){
		try {
			DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream input = new DataInputStream(clientSocket.getInputStream());
			String message = input.readUTF();
			System.out.println("recibido ... "+ message);
			boolean exit = false; 
			do {
				System.out.println("Esperando el tipo de operacion...");
				int option = input.read();
				System.out.println("El tipo de operacion es: " + option);
				if(option == 1){
					String name = input.readUTF();
					long number = input.readLong();
					String email = input.readUTF();
					contacts.addContact(name, number, email);
				}
				else if (option == 2) {
					String name = input.readUTF();
					output.writeUTF(contacts.getContactData(name));
				}
				else if (option == 3) {
					String name = input.readUTF();
					contacts.deleteContact(name);
				}
				else if(option == 4) {
					output.writeUTF(contacts.showContacts());
				}
				else if (option == 5) {
					output.writeUTF(contacts.getFirstContact());
					output.writeUTF(contacts.getLastContact());
					output.write(contacts.getnumberContacts());
				}
				else if(option == 6) {
					exit = true;
				}else{
					System.out.print("Error");
				}
			}while(!exit);
			clientSocket.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
