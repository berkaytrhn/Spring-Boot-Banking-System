package com.berkay.banking_system_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.berkay.banking_system_project.request.BankCreateRequest;
import com.berkay.banking_system_project.service.BankService;

@RestController
@RequestMapping("/api/v1/")
public class BankController {
	
	
	@Autowired
	private BankService bankService;

	@RequestMapping(path="bank", method=RequestMethod.POST)
	public ResponseEntity<Object> createBank(BankCreateRequest bankCreateRequest){
		if (this.bankService.createBank(bankCreateRequest) == null) return new ResponseEntity<Object>("Bank already exist!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Object>("Created Successfuly!", HttpStatus.OK);
	
	}
	
	
	
	
	
}
