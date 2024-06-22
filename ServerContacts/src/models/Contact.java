package models;

public class Contact {
	private String name, email;
	private long number;
	
	public Contact(String name, long number, String email) {
		this.name = name;
		this.email = email;
		this.number = number;
	}
	
	public Contact(String name) {
		this.name = name;
	}
	
	public Contact(String name, long number) {
		this.name = name;
		this.number = number;
	}
	
	public Contact(String name, String email) {
		this.name = name;
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		if(number==0 && email==null) {
			return "Contacto: " + name + "\n";
		}else if(email==null) {
			return "Contacto: " + name + ", numero: " + number+ "\n";
		}else if(number==0) {
			return "Contacto: " + name + ", email: " + email+ "\n";
		}else{
			return "Contacto: " + name + ", numero: " + number + ", email: " + email + "\n";
		}
	}
	
	
}
