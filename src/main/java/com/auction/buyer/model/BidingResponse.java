package com.auction.buyer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BidingResponse {

	@JsonProperty("successMsg")
	private String successMsg;
	
	@JsonProperty("errorMsg")
	private String errorMsg;

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
