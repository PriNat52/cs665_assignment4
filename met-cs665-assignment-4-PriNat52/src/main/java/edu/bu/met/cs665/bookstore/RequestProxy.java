package edu.bu.met.cs665.bookstore;

/*
 * Proxy pattern - To convert the requests to the old API, customer email address should be forwarded and 
 * customer phone number be dropped.
 * */
public class RequestProxy implements NewVersion{

	private String email;
	private String phoneNumber;
	
	public RequestProxy(String string, String phoneNumber) {
		this.email=string;
		this.setPhoneNumber(phoneNumber);
	}
	
	@Override
	public Customer getCustomer(String email, String phoneNumber) {
		
		Customer data  = new DataAccess().getCustomer(this.email);
		return data;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
