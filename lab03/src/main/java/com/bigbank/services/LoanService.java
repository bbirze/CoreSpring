package com.bigbank.services;

import com.bigbank.domain.Borrower;

public interface LoanService {
	
	boolean processLoan(Borrower b);
}
