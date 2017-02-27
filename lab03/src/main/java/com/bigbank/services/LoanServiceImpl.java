package com.bigbank.services;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bigbank.domain.Borrower;
import com.bigbank.domain.Loan;

public class LoanServiceImpl implements LoanService {

	@Override
	public boolean processLoan(Borrower b) {
		Random rand = new Random();
		int threshold = rand.nextInt(30000);
		
		Loan l = b.getTheLoan();
		System.out.println("loan amt: " + l.getAmount() + " Price: " + l.getPurchasePrice()
				+" Loan Threshold: " + threshold); 
		if (l.getAmount() > l.getPurchasePrice()) {
			l.setStatus("Rejected");
			return false;
		}
		if (l.getAmount() > threshold)  {
			l.setStatus("Rejected");
			return false;		
		}
		l.setStatus("Approveds");
		return true;
	}

}
