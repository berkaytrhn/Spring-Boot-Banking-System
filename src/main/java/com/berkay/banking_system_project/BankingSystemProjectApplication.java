package com.berkay.banking_system_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingSystemProjectApplication {

	
	//private final static Logger rootLogger = Logger.getRootLogger();
	
	public static void main(String[] args) {
		//rootLogger.addAppender(new ConsoleAppender(new PatternLayout("%r [%t] %p %c %x - %m%n")));
		SpringApplication.run(BankingSystemProjectApplication.class, args);
	}

}
