package edu.bu.met.cs665.bookstore;

/*
 * In this process, adding and welcome email are generated
 * */
public class AddProcess implements CommandCheck{

	private Customer email;
	
	public AddProcess(final Customer email) {
		this.email = email;
	}
	
	@Override
	public void execute() {
		
		email.add();
	}

	@Override
	public void generate() {
		
		email.generate();
	}
}
