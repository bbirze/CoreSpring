package com.bigbank.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bigbank.domain.Borrower;
import com.bigbank.domain.LoanManager;

public class LoanApplication {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new FileSystemXmlApplicationContext("src/main/java/spring.xml");
		
		Borrower bwer = (Borrower)ctx.getBean("borrower01");
		LoanManager lMgr = (LoanManager)ctx.getBean("loanManager");
		
		lMgr.applyForLoan(bwer);

		ctx.close();
	}

}
