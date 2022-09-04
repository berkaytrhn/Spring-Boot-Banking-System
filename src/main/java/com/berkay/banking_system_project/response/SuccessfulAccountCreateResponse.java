package com.berkay.banking_system_project.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessfulAccountCreateResponse {
	private final String message="Account Created!";
	private long accountId;;
	
	public SuccessfulAccountCreateResponse(long accountId) {
		this.accountId=accountId;
	}
}