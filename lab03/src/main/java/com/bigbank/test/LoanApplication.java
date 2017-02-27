package com.bigbank.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bigbank.configuration.LoanManagerConfig;
import com.bigbank.domain.Borrower;
import com.bigbank.domain.Loan;
import com.bigbank.domain.LoanManager;

public class LoanApplication {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new AnnotationConfigApplicationContext(LoanManagerConfig.class);
		
		Borrower bwer = (Borrower)ctx.getBean("borrower01");
		LoanManager lMgr = (LoanManager)ctx.getBean("loanManager");
		
		lMgr.applyForLoan(bwer);

		Loan myLoan = (Loan)ctx.getBean("loan02");
		System.out.println("Loan02: " + myLoan);
		ctx.close();
	}

}
