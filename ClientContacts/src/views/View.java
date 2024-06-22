package views;

import java.util.Scanner;

public class View {
	
	private Scanner scanner;
	
	public View() {
		scanner = new Scanner(System.in);
	}
	
	public void showFirst(String first) {
		System.out.println(MyMessage.FIRST);
		System.out.println(first);
	}
	
	public void showLast(String last) {
		System.out.println(MyMessage.LAST);
		System.out.println(last);
	}
	
	public void showQuantity(int quantity) {
		System.out.println(MyMessage.QUANTITY);
		System.out.println(quantity);
	}
	
	public void showMenu() {
		System.out.println(MyMessage.MENU);
	}
	
	public void showNoImplemented() {
		System.out.println(MyMessage.NOT_IMPLEMENTED);
	}
	
	public void showNoExist() {
		System.out.println(MyMessage.NOT_EXISTS);
	}
	
	public void showContacts(String contacts) {
		System.out.println(MyMessage.SINGS_RIGHT + MyMessage.LIST_CONTACTS + MyMessage.SINGS_LEFT);
		System.out.println(contacts);
	}
	
	public void showInformationContact(String contact) {
		System.out.println(MyMessage.SINGS_RIGHT + MyMessage.INFORMATION + MyMessage.SINGS_LEFT);
		System.out.println(contact);
	}
	
	public String getName() {
		System.out.println(MyMessage.IN_NAME);
		return scanner.nextLine();
	}
	
	public int getOption() {
		int option = 0;
		System.out.println(MyMessage.GET_OPTION);
		try {
			option = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			showMessageInvalidOption();
		}
		return option;
	}
	
	public void showMessageInvalidOption() {
		System.out.println(MyMessage.INVALID_OPTION);
	}
	
	public void showMessageFinish() {
		System.out.println(MyMessage.THANKS);
	}
	
	public long getNumber() {
		long number = 0;
		System.out.println(MyMessage.IN_NUMBER);
		String string = scanner.nextLine();
		if(string.equals("")) {
			string = "0";
		}
		number = Long.parseLong(string);
		return number;
	}
	
	public String getEmail() {
		System.out.println(MyMessage.IN_EMAIL);
		return scanner.nextLine();
	}

}
