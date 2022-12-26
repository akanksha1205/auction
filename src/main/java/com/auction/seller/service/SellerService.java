package com.auction.seller.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auction.seller.model.AddProductRequest;
import com.auction.seller.model.AddProductResponse;
import com.auction.seller.model.BidingDetails;


@Service
@Transactional
public interface SellerService {

	AddProductResponse addProduct(AddProductRequest addProductRequest);
	
	public List<BidingDetails> findBidingDetail(Integer productId);
	
	public AddProductResponse deleteProduct(Integer productId);
}
