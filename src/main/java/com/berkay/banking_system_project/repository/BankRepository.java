package com.berkay.banking_system_project.repository;

import org.apache.ibatis.annotations.Mapper;

import com.berkay.banking_system_project.models.Bank;

@Mapper
public interface BankRepository {
	
	
	public Bank getBankByNamed(String name);
	
	public boolean createBank(Bank bank);
}
