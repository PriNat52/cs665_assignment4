package edu.bu.met.cs665.bookstore;

import org.apache.log4j.Logger;

public class Customer {

	private int memberId;
	private String memberName;
	private String email;
	private String phoneNumber;
	private String process;
	
	private static Logger logger = Logger.getLogger(Customer.class);
	
	public Customer(int memberId, String memberName, String email, String phoneNumber) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.email= email;
		this.phoneNumber = phoneNumber;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Id: "+ memberId +" Name: "+ memberName +" E-mail: "+ email +" Phone Number: "+ phoneNumber;
	}
	
	/*
	 * Command Pattern - Receiver
	 * */
	
	public void add() {
		logger.error("Verification Successfull!");
		setProcess("Verification Successfull!");
	}
	
	public void generate() {
		logger.error("Welcome Email Ready to Send!!");
		setProcess("Email Ready and Sent!!");
	}
	
	public void reject() {
		logger.error("Rejection Email Ready to Send!!");
		setProcess("Email Ready and Sent!!");
	}
	
	public void remove() {
		logger.error("Verification Unsuccessfull!");
		setProcess("Verification Unsuccessfull!");
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}
}
