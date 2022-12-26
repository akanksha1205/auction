package com.auction.buyer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auction.buyer.model.BidingRequest;
import com.auction.buyer.model.BidingResponse;

@Service
@Transactional
public interface BuyerService {

	BidingResponse bidProduct(BidingRequest bidingRequest);
	
	BidingResponse updateProduct(Integer productId, String emailId, Integer newBidAmount);
}
