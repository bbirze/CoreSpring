package com.bigbank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.bigbank.domain.LoanManager;
import com.bigbank.services.LoanService;
import com.bigbank.services.LoanServiceImpl;

@Configuration
@ComponentScan(basePackages="com.bigbank.domain")
@ImportResource({"classpath:spring.xml","classpath:springConfig.groovy"})
public class LoanManagerConfig {

	@Bean
	public LoanService loanService()  {
		return new LoanServiceImpl();
	}
	
	
	@Bean 
	public LoanManager loanManager()  {
		LoanManager mgr = new LoanManager();
		mgr.setLoanService(loanService());
		return mgr;
	}
	
}
