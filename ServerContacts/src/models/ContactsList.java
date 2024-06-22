package models;

import java.util.List;

import structures.TreeAVL;

public class ContactsList {
	
	private TreeAVL<Contact> contacts;
	
	public ContactsList() {
		contacts = new TreeAVL<Contact>(new ComparatorContact());
	}
	
	
	public void addContact(String name, long number, String email) {
		if(number==0 && email=="") {
			contacts.insert(new Contact(name));
		}else if(email=="") {
			contacts.insert(new Contact(name, number));
		}else if(number==0) {
			contacts.insert(new Contact(name, email));
		}else {
			contacts.insert(new Contact(name, number, email));
		}	
	}
	
	public String getContactData(String name) {
		Contact aux = null;
		List<Contact> list = contacts.getInOrder();
		for(Contact data: list) {
			if(data.getName().equals(name)) {
				aux = data;
			}
		}
		return contacts.search(aux).toString();	
	}
	
	public void deleteContact(String name) {
		Contact aux = null;
		List<Contact> list = contacts.getInOrder();
		for(Contact data: list) {
			if(data.getName().equals(name)) {
				aux = data;
			}
		}
		contacts.remove(aux);
	}
	
	public String showContacts() {
		List<Contact> list = contacts.getInOrder();
		String string = "";
		for(Contact data: list) {
			string += data + "\n";
		}
		return string;
	}
	
	public String getFirstContact() {
		List<Contact> list = contacts.getInOrder();
		String string = "";
		string += list.get(0).toString();
		return string;
	}
	
	public String getLastContact() {
		List<Contact> list = contacts.getInOrder();
		String string = "";
		string += list.get(list.size()-1).toString();
		return string;
	}
	
	public int getnumberContacts() {
		return contacts.count();
	}
}
