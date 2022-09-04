package com.berkay.banking_system_project.request;

import lombok.Data;

@Data
public class TransferMoneyRequest {
	private int transferredAccountId;
	private double amount;
}
