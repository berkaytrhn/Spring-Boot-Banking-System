package com.berkay.banking_system_project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.berkay.banking_system_project.models.Bank;
import com.berkay.banking_system_project.repository.BankRepository;
import com.berkay.banking_system_project.request.BankCreateRequest;

public class BankService {

	@Autowired
	private BankRepository bankRepository;
	
	
	
	public Bank createBank(BankCreateRequest bankCreateRequest) {
		if (getBank(bankCreateRequest.getName()) == null); else return null;
		
		Bank bank = Bank.builder()
				.name(bankCreateRequest.getName())
				.build();
		if (this.bankRepository.createBank(bank)) return bank; else return null;
	}
	
	public Bank getBank(String name) {
		return this.bankRepository.getBankByNamed(name);
	}
}
