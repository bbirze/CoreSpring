package com.bigbank.domain;

public class Borrower {

	private int borrowerID;
	private String name;
	private String address;
	private String phone;
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
