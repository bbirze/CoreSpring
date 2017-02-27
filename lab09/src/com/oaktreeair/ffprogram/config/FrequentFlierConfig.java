package com.oaktreeair.ffprogram.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.oaktreeair.ffprogram")
@EnableTransactionManagement
public class FrequentFlierConfig {

	@Bean
	public DataSource flierDataSource() {
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource("jdbc/flier");
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager getTransactionManager()  {
		return new DataSourceTransactionManager(flierDataSource());
	}

}
