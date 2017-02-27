package com.bigbank.domain;

import com.bigbank.services.LoanService;

public class LoanManager {

	private LoanService loanService;

	public void applyForLoan(Borrower b) {
		boolean rating = loanService.processLoan(b);
		System.out.println("Loan status is " + b.getTheLoan().getStatus());
		
		if (rating) {
			System.out.println("Here's a free toaster!");
		} else {
			System.out.println("Sorry, no loan today");
		}
	}
	

	public LoanService getLoanService() {
		return loanService;
	}

	public void setLoanService(LoanService loanService) {
		this.loanService = loanService;
	}

}
