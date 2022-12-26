package com.auction.seller.controllertest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.auction.seller.controller.AuctionEndPoint;
import com.auction.seller.model.AddProductRequest;
import com.auction.seller.model.AddProductResponse;
import com.auction.seller.model.BidingDetailResponse;
import com.auction.seller.service.SellerService;

public class SellerControllerTest {
	
	@Mock
	SellerService sellerService;
	
	@InjectMocks
	AuctionEndPoint auctionEndPoint;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(auctionEndPoint, "sellerService", sellerService);
	}
	
	@Test
	void addProductTest() {
		AddProductRequest addProductRequest = new AddProductRequest();
		AddProductResponse addProductResponse = new AddProductResponse();
		addProductRequest.setBidEndDate("2023-06-13");
		addProductRequest.setCategory("Ornament");
		addProductRequest.setDetailedDescription("Pure gold Ornament");
		addProductRequest.setProductName("Ring");
		addProductRequest.setSellerAddress("51,Mango");
		addProductRequest.setSellerCity("Jsr");
		addProductRequest.setSellerEmail("akanksha@gmail.com");
		addProductRequest.setSellerFirstName("Akanksha");
		addProductRequest.setSellerLastName("Ranjan");
		addProductRequest.setSellerPhone("7896774567");
		addProductRequest.setSellerPin("832110");
		addProductRequest.setSellerState("Jharkhand");
		addProductRequest.setShortDescription("Gold ring");
		addProductRequest.setStartingPrice("3999");
		ResponseEntity<AddProductResponse> addProductRequest2 = auctionEndPoint.addProduct(addProductRequest);
		assertNotNull(addProductRequest2);
	}
	
	@Test
	void bidingDetailsTest() {
		BidingDetailResponse bidingDetailResponse = new BidingDetailResponse();
		Integer productId = 12;
		ResponseEntity<BidingDetailResponse> bidingDetailResponse2 = auctionEndPoint.bidingDetails(productId);
		assertNotNull(bidingDetailResponse2);
	}
	
	@Test
	void deleteProductTest() {
		AddProductResponse addProductResponse = new AddProductResponse();
		Integer productId = 12;
		ResponseEntity<AddProductResponse> addProductResponse2 = auctionEndPoint.deleteProduct(productId);
		assertNotNull(addProductResponse2);
	}
}
