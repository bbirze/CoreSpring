package com.bigbank.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigbank.services.LoanService;

@Component("loanManager")
public class LoanManager {

	// could also use @Resource with no name specified
	@Autowired
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
}
