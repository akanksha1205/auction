package com.auction.buyer.controllertest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.bind.annotation.PathVariable;

import com.auction.buyer.controller.BidingController;
import com.auction.buyer.model.BidingRequest;
import com.auction.buyer.model.BidingResponse;
import com.auction.buyer.service.BuyerService;

public class BuyerControllerTest {
	
	@Mock
	BuyerService buyerService;
	
	@InjectMocks
	BidingController bidingController;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(bidingController, "buyerService", buyerService);
	}
	
	@Test
	void bidProductTest() {
		BidingResponse bidingResponse = new BidingResponse();
		BidingRequest bidingRequest = new BidingRequest();
		bidingRequest.setAddress("51, Mango");
		bidingRequest.setBidAmount(5000);
		bidingRequest.setCity("Tata");
		bidingRequest.setEmailId("ak@gmail.com");
		bidingRequest.setFirstName("Akanksha");
		bidingRequest.setLastName("Ranjan");
		bidingRequest.setPhone("63839739739");
		bidingRequest.setPin("832110");
		bidingRequest.setProductId(12);
		bidingRequest.setState("Jharkhand");
		ResponseEntity<BidingResponse> bidingResponse2 = bidingController.bidProduct(bidingRequest);
		
		assertNotNull(bidingResponse2);
		
	}
	
	@Test
	void updateProductTest() {
		BidingResponse bidingResponse = new BidingResponse();
		Integer productId = 12;
		String emailId = "akanksha@gmail.com";
		Integer newBidAmount = 6000;		
		ResponseEntity<BidingResponse> bidingResponse2 = bidingController.updateProduct(productId, emailId, newBidAmount);
		assertNotNull(bidingResponse2);
	}
	
	

}
