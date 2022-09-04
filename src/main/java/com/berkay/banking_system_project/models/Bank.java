package com.berkay.banking_system_project.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bank {

	private int id;
	private String name;
}
