package com.auction.seller.model;

import java.util.List;

public class BidingDetailResponse {

	private List<BidingDetails> bidingDetails;
	
	private String errorMsg;
	

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<BidingDetails> getBidingDetails() {
		return bidingDetails;
	}

	public void setBidingDetails(List<BidingDetails> bidingDetails) {
		this.bidingDetails = bidingDetails;
	}
	
	
}
