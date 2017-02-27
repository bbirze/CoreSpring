package com.bigbank.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("borrower01")
public class Borrower {

	@Value("0987654")
	private int borrowerID;

	@Value("Samantha Giddy")
	private String name;

	@Value("350 Second Ave, Anywhere, DE")
	private String address;

	@Value("214.976.3500")
	private String phone;
	
	@Resource(name="loan01")
	private Loan theLoan;
	
	public int getBorrowerID() {
		return borrowerID;
	}
	public void setBorrowerID(int borrowerID) {
		this.borrowerID = borrowerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Loan getTheLoan() {
		return theLoan;
	}
	public void setTheLoan(Loan theLoan) {
		this.theLoan = theLoan;
	}
	
	
}
