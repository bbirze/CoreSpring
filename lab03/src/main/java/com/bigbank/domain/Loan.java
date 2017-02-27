package com.bigbank.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("loan01")
public class Loan {
	@Value("12345678")
	private int loanID;

	@Value("3500")
	private int amount;

	@Value("4500")
	private int purchasePrice;
	
	private String status;

	@Value("4653 Main Blvd, Pleasantville, DE")
	private String propertyAddress;

	public int getLoanID() {
		return loanID;
	}
	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	@Override
	public String toString() {
		return "Loan [loanID=" + loanID + ", amount=" + amount + ", purchasePrice=" + purchasePrice + ", status="
				+ status + ", propertyAddress=" + propertyAddress + "]";
	}
	
	
	
	
}
