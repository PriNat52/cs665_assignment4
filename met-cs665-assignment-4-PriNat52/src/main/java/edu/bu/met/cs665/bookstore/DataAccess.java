package edu.bu.met.cs665.bookstore;

import java.util.ArrayList;
import java.util.List;

public class DataAccess implements OldVersion{

	int memberId = 0;
	String memberName = "Error";
	String phoneNumber = "000-xxx-yyyy";
	 
	public DataAccess() {}

	@Override
	public Customer getCustomer(String email) {
	
		Customer customer1 = new Customer(1, "Jay", "jay@hubber.com", "546-907-4563");
		Customer customer2 = new Customer(2, "Jason", "jason@hubber.com", "546-907-4563");
		Customer customer3 = new Customer(3, "Laila", "laila@hubber.com", "576-227-5412");
		Customer customer4 = new Customer(4, "Alex", "alex@hubber.com", "543-007-9987");

		List<Customer> record = new ArrayList<Customer>();
		record.add(customer1);
		record.add(customer2);
		record.add(customer3);
		record.add(customer4);
		
		for(int i=0; i<=record.size(); i++) {
			if(email.equals(record.get(i).getEmail())) {
				return record.get(i);
			}
		}
		
		Customer data = new Customer(memberId, memberName, email, phoneNumber);
		return data;
	}

}
