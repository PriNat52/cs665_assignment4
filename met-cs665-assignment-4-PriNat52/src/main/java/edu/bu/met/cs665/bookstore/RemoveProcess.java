package edu.bu.met.cs665.bookstore;

/*
 * In this process, removing and rejecting emails are generated
 * */
public class RemoveProcess implements CommandCheck{

	private Customer email;
	
	public RemoveProcess(final Customer email) {
		this.email = email;
	}
	
	@Override
	public void execute() {
		
		email.remove();
	}

	@Override
	public void generate() {
		
		email.reject();
	}
}
