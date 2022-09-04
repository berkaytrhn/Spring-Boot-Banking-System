package com.berkay.banking_system_project;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(path="/hello/{message}", method=RequestMethod.GET)
	public ResponseEntity<Object> hello(@PathVariable String message){


		
		logger.warn(String.format("%s------------%s", "eqmlwekqmwelqkwemqlwekqmweqlwkemq", message));
		System.out.println(logger.isDebugEnabled());
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("%s------------%s", "eqmlwekqmwelqkwemqlwekqmweqlwkemq", message));
		}		
		
		return new ResponseEntity<Object>(message, HttpStatus.OK);
		
		
		
	}
	
	
}
