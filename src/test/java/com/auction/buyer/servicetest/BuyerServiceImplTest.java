package com.auction.buyer.servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import com.auction.buyer.entity.BuyerEntity;
import com.auction.buyer.entity.ProductEntity;
import com.auction.buyer.model.BidingRequest;
import com.auction.buyer.model.BidingResponse;
import com.auction.buyer.repository.BidingRepository;
import com.auction.buyer.repository.ProductRepository;

public class BuyerServiceImplTest {
	
	@Mock
	BidingRepository bidingRepository;
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	com.auction.buyer.service.BuyerServiceImpl buyerServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(buyerServiceImpl, "bidingRepository", bidingRepository);
		ReflectionTestUtils.setField(buyerServiceImpl, "productRepository", productRepository);
		
	}
	
	@Test
	void bidProductTest() {
		BidingRequest bidingRequest = new BidingRequest();
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
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
		//when(bidingRepository.duplicateBiding(bidingRequest.getEmailId(), bidingRequest.getProductId())).thenReturn(buyerEntity);
		bidingResponse = buyerServiceImpl.bidProduct(bidingRequest);
		
		assertNotNull(bidingResponse);
	}
	@Test
	void bidProduct2Test() {
		BidingRequest bidingRequest = new BidingRequest();
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		bidingRequest.setAddress("51, Mango");
		bidingRequest.setBidAmount(5000);
		bidingRequest.setCity("Tata");
		bidingRequest.setEmailId("ak89@gmail.com");
		bidingRequest.setFirstName("Akanksha");
		bidingRequest.setLastName("Ranjan");
		bidingRequest.setPhone("63839739739");
		bidingRequest.setPin("832110");
		bidingRequest.setProductId(12);
		bidingRequest.setState("Jharkhand");
		when(bidingRepository.duplicateBiding(bidingRequest.getEmailId(), bidingRequest.getProductId())).thenReturn(buyerEntity);
		bidingResponse = buyerServiceImpl.bidProduct(bidingRequest);
		
		assertNotNull(bidingResponse);
	}
	@Test
	void bidProduct3Test() {
		BidingRequest bidingRequest = new BidingRequest();
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		ProductEntity productEntity =new ProductEntity();
		
		bidingRequest.setAddress("51, Mango");
		bidingRequest.setBidAmount(5000);
		bidingRequest.setCity("Tata");
		bidingRequest.setEmailId("ak89@gmail.com");
		bidingRequest.setFirstName("Akanksha");
		bidingRequest.setLastName("Ranjan");
		bidingRequest.setPhone("63839739739");
		bidingRequest.setPin("832110");
		bidingRequest.setProductId(12);
		bidingRequest.setState("Jharkhand");
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2023-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		productEntity.setStartingPrice("400");
		Optional<ProductEntity> optional = Optional.of(productEntity);
		//when(bidingRepository.duplicateBiding(bidingRequest.getEmailId(), bidingRequest.getProductId())).thenReturn(buyerEntity);
		when(productRepository.findById(12)).thenReturn(optional);
		bidingResponse = buyerServiceImpl.bidProduct(bidingRequest);
		
		assertNotNull(bidingResponse);
	}
	@Test
	void bidProduct4Test() {
		BidingRequest bidingRequest = new BidingRequest();
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		ProductEntity productEntity =new ProductEntity();
		
		bidingRequest.setAddress("51, Mango");
		bidingRequest.setBidAmount(5000);
		bidingRequest.setCity("Tata");
		bidingRequest.setEmailId("ak89@gmail.com");
		bidingRequest.setFirstName("Akanksha");
		bidingRequest.setLastName("Ranjan");
		bidingRequest.setPhone("63839739739");
		bidingRequest.setPin("832110");
		bidingRequest.setProductId(12);
		bidingRequest.setState("Jharkhand");
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		productEntity.setStartingPrice("400");
		Optional<ProductEntity> optional = Optional.of(productEntity);
		//when(bidingRepository.duplicateBiding(bidingRequest.getEmailId(), bidingRequest.getProductId())).thenReturn(buyerEntity);
		when(productRepository.findById(12)).thenReturn(optional);
		bidingResponse = buyerServiceImpl.bidProduct(bidingRequest);
		
		assertNotNull(bidingResponse);
	}

	@Test
	void bidProduct5Test() {
		BidingRequest bidingRequest = new BidingRequest();
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		ProductEntity productEntity =new ProductEntity();
		
		bidingRequest.setAddress("51, Mango");
		bidingRequest.setBidAmount(5000);
		bidingRequest.setCity("Tata");
		bidingRequest.setEmailId("ak89@gmail.com");
		bidingRequest.setFirstName("Akanksha");
		bidingRequest.setLastName("Ranjan");
		bidingRequest.setPhone("63839739739");
		bidingRequest.setPin("832110");
		bidingRequest.setProductId(12);
		bidingRequest.setState("Jharkhand");
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2024-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		productEntity.setStartingPrice("405550");
		
		
		Optional<ProductEntity> optional = Optional.of(productEntity);
		//when(bidingRepository.duplicateBiding(bidingRequest.getEmailId(), bidingRequest.getProductId())).thenReturn(buyerEntity);
		when(productRepository.findById(12)).thenReturn(optional);
		
		bidingResponse = buyerServiceImpl.bidProduct(bidingRequest);
		
		assertNotNull(bidingResponse);
	}

	@Test
	void updateProductTest() {
		BidingResponse bidingResponse = new BidingResponse();
		
		Integer productId = 22;
		String emailId = "akanksha@gmail.com";
		Integer newBidAmount = 2300;
		bidingResponse =buyerServiceImpl.updateProduct(productId, emailId, newBidAmount);
		assertNotNull(bidingResponse);
	}
	
	@Test
	void updateProduct2Test() {
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		ProductEntity productEntity = new ProductEntity();
		buyerEntity.setBidAmount(5000);
		Integer productId = 12;
		String emailId = "akanksha@gmail.com";
		Integer newBidAmount = 6000;
		when(bidingRepository.duplicateBiding("akanksha@gmail.com",12)).thenReturn(buyerEntity);
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2023-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		
		Optional<ProductEntity> optional = Optional.of(productEntity);
		when(productRepository.findById(12)).thenReturn(optional);
		bidingResponse =buyerServiceImpl.updateProduct(productId, emailId, newBidAmount);
		
		assertNotNull(bidingResponse);
	}
	
	@Test
	void updateProduct3Test() {
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		ProductEntity productEntity = new ProductEntity();
		buyerEntity.setBidAmount(5000);
		Integer productId = 12;
		String emailId = "akanksha@gmail.com";
		Integer newBidAmount = 6000;
		when(bidingRepository.duplicateBiding("akanksha@gmail.com",12)).thenReturn(buyerEntity);
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		
		Optional<ProductEntity> optional = Optional.of(productEntity);
		when(productRepository.findById(12)).thenReturn(optional);
		bidingResponse =buyerServiceImpl.updateProduct(productId, emailId, newBidAmount);
		
		assertNotNull(bidingResponse);
	}
	
	@Test
	void updateProduct4Test() {
		BidingResponse bidingResponse = new BidingResponse();
		BuyerEntity buyerEntity = new BuyerEntity();
		ProductEntity productEntity = new ProductEntity();
		buyerEntity.setBidAmount(8000);
		Integer productId = 12;
		String emailId = "akanksha@gmail.com";
		Integer newBidAmount = 4000;
		when(bidingRepository.duplicateBiding("akanksha@gmail.com",12)).thenReturn(buyerEntity);
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2025-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		Optional<ProductEntity> optional = Optional.of(productEntity);
		when(productRepository.findById(12)).thenReturn(optional);
		bidingResponse =buyerServiceImpl.updateProduct(productId, emailId, newBidAmount);
		
		assertNotNull(bidingResponse);
	}
}
