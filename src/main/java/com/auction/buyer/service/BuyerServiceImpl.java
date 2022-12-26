package com.auction.buyer.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auction.buyer.entity.BuyerEmbedded;
import com.auction.buyer.entity.BuyerEntity;
import com.auction.buyer.entity.ProductEntity;
import com.auction.buyer.model.BidingRequest;
import com.auction.buyer.model.BidingResponse;
import com.auction.buyer.repository.BidingRepository;
import com.auction.buyer.repository.ProductRepository;


@Service
@Transactional
public class BuyerServiceImpl implements BuyerService{

	@Autowired
	BidingRepository bidingRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public BidingResponse bidProduct(BidingRequest bidingRequest) {
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		ProductEntity productEntity = new ProductEntity();
		
		
		BuyerEntity	buyerEntity2 = bidingRepository.duplicateBiding(bidingRequest.getEmailId(), bidingRequest.getProductId());
		if(buyerEntity2 != null ) {
			bidingResponse.setErrorMsg("Buyer already bidded this product");
			return bidingResponse;
		}
		
		buyerEntity.setFirstName(bidingRequest.getFirstName());
		buyerEntity.setLastName(bidingRequest.getLastName());
		buyerEntity.setAddress(bidingRequest.getAddress());
		buyerEntity.setCity(bidingRequest.getCity());
		buyerEntity.setState(bidingRequest.getState());
		buyerEntity.setPin(bidingRequest.getPin());
		buyerEntity.setPhone(bidingRequest.getPhone());
		
		buyerEntity.setBuyerEmbedded(new BuyerEmbedded());
		buyerEntity.getBuyerEmbedded().setEmailId(bidingRequest.getEmailId());
		buyerEntity.getBuyerEmbedded().setProductId(bidingRequest.getProductId());
		
		Optional<ProductEntity> optional = productRepository.findById(bidingRequest.getProductId());
		if(optional.isPresent()) {
			productEntity = optional.get();			
		}
		else {
			bidingResponse.setErrorMsg("Product Id not present");
			return bidingResponse;
		}
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");		
		java.sql.Date sqlDate = productEntity.getBidEndDate() ;
		Date date = new Date(sqlDate.getTime());		
		
		Date currDate = new Date();
		if(currDate.after(date)) {
			bidingResponse.setErrorMsg("Biding closed for this product");
			return bidingResponse;
		}
		if(bidingRequest.getBidAmount()<Integer.parseInt(productEntity.getStartingPrice())) {
			bidingResponse.setErrorMsg("Biding amount is less");
			return bidingResponse;
		}
		buyerEntity.setBidAmount(bidingRequest.getBidAmount());
		
		try {
			buyerEntity = bidingRepository.save(buyerEntity);
		} catch (Exception e) {
			bidingResponse.setErrorMsg(e.getMessage());
			return bidingResponse;
		}
		bidingResponse.setSuccessMsg("Biding done");
		
		return bidingResponse;
	}

	@Override
	public BidingResponse updateProduct(Integer productId, String emailId, Integer newBidAmount) {
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		ProductEntity productEntity = new ProductEntity();
		
		BuyerEntity	buyerEntity2 = bidingRepository.duplicateBiding(emailId, productId);
		if(buyerEntity2 == null ) {
			bidingResponse.setErrorMsg("Buyer never bidded this product");
			return bidingResponse;
		}
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");		
		Optional<ProductEntity> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			productEntity = optional.get();
		}
		java.sql.Date sqlDate = productEntity.getBidEndDate();
		Date date = new Date(sqlDate.getTime());		
		
		Date currDate = new Date();
		if(currDate.after(date)) {
			bidingResponse.setErrorMsg("Biding closed for this product");
			return bidingResponse;
		}
		
		if(buyerEntity2.getBidAmount()>newBidAmount) {
			bidingResponse.setErrorMsg("Biding amount is less");
			return bidingResponse;
		}
	
		try {
			buyerEntity2.setBidAmount(newBidAmount);
			buyerEntity2 = bidingRepository.save(buyerEntity2);
		} catch (Exception e) {
			bidingResponse.setErrorMsg(e.getMessage());
			return bidingResponse;
		}
		bidingResponse.setSuccessMsg("Updated biding amount for this product");
		
		return bidingResponse;
	}


}
