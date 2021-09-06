package edu.bu.met.cs665.testbookshop;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.bu.met.cs665.bookstore.AddProcess;
import edu.bu.met.cs665.bookstore.BackgroundCheck;
import edu.bu.met.cs665.bookstore.CommandCheck;
import edu.bu.met.cs665.bookstore.EmailVerification;
import edu.bu.met.cs665.bookstore.RemoveProcess;
import edu.bu.met.cs665.bookstore.RequestProxy;
import edu.bu.met.cs665.bookstore.WelcomeEmail;

public class TestCustomerBookShop {

	@Test
	public void test() {
		Logger logger = Logger.getLogger(TestCustomerBookShop.class);
		
		/*
		 * Test 1: Converting the requests to the old API, customer email address should be forwarded 
		 * and customer phone number be dropped
		 * */
		RequestProxy first = new RequestProxy("laila@hubber.com", "576-227-5412");
		logger.error(first.getCustomer("laila@hubber.com", "576-227-5412"));
		
		/*
		 * Test 2: company may need to run some of these data processing steps
		 * and needs the flexibility to add or remove them
		 * 
		 * Trial 1: Successful case and checking the flexibility
		 * */
		RequestProxy request = new RequestProxy("jason@hubber.com", "546-907-4563");
		logger.error("[Successful Case:]Data Processing Starts for "+ request.getCustomer("jason@hubber.com", "546-907-4563"));
		CommandCheck command = new AddProcess(request.getCustomer("jason@hubber.com", "546-907-4563"));
		
		EmailVerification emailVerify = new EmailVerification();
		logger.error("(1) Email Adress Verification:");
		emailVerify.execute(command);
		
		BackgroundCheck background = new BackgroundCheck();
		logger.error("(2) Background Checks:");
		background.execute(command);
		
		WelcomeEmail welcome = new WelcomeEmail();
		logger.error("(3) Welcome Email:");
		welcome.execute(command);
		
		logger.error("**[Successfull Case:]Ends**");
		
		/*
		 * Test 2 - Trial 2: Unsuccessful case and checking the flexibility
		 * */
		RequestProxy requests = new RequestProxy("alex@hubber.com", "543-007-9987");
		
		logger.error("[Unsuccessfull Case:]Data Processing for "+ requests.getCustomer("alex@hubber.com", "543-007-9987"));
		CommandCheck commands = new RemoveProcess(requests.getCustomer("alex@hubber.com", "543-007-9987"));
		
		EmailVerification emailVerification = new EmailVerification();
		logger.error("(1) Email Adress Verification:");
		emailVerification.execute(commands);
		
		BackgroundCheck backgrounds = new BackgroundCheck();
		logger.error("(2) Background Checks:");
		backgrounds.execute(commands);
		
		WelcomeEmail welcomes = new WelcomeEmail();
		logger.error("(3) Rejection Email:");
		welcomes.execute(commands);
		
		logger.error("**[Unsuccessfull Case:]Ends**");
	}

}