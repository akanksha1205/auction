package com.auction.seller.servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.auction.seller.entity.BuyerEmbedded;
import com.auction.seller.entity.BuyerEntity;
import com.auction.seller.entity.ProductEntity;
import com.auction.seller.model.AddProductRequest;
import com.auction.seller.model.AddProductResponse;
import com.auction.seller.model.BidingDetails;
import com.auction.seller.repository.BuyerRepository;
import com.auction.seller.repository.ProductRepository;
import com.auction.seller.service.SellerServiceImpl;

public class SellerServiceImplTest {
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	BuyerRepository buyerRepository;
	
	@InjectMocks
	SellerServiceImpl sellerServiceImpl;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(sellerServiceImpl, "productRepository", productRepository);
		ReflectionTestUtils.setField(sellerServiceImpl, "buyerRepository", buyerRepository);
		
	}
	
	@Test
	void addProductTest() {
		AddProductRequest addProductRequest = new AddProductRequest();
		AddProductResponse addProductResponse = new AddProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductEntity productEntity2 = new ProductEntity();
		productEntity.setProductId(12);
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
		
		when(productRepository.save(productEntity2)).thenReturn(productEntity);
		addProductResponse = sellerServiceImpl.addProduct(addProductRequest);
		assertNotNull(addProductResponse);
	}
	
	@Test
	void addProduct2Test() {
		AddProductRequest addProductRequest = new AddProductRequest();
		AddProductResponse addProductResponse = new AddProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductEntity productEntity2 = new ProductEntity();
		productEntity.setProductId(12);
		addProductRequest.setBidEndDate("2023-06-13");
		addProductRequest.setCategory("Sculptor");
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
		
		when(productRepository.save(productEntity2)).thenReturn(productEntity);
		addProductResponse = sellerServiceImpl.addProduct(addProductRequest);
		assertNotNull(addProductResponse);
	}
	
	@Test
	void addProduct3Test() {
		AddProductRequest addProductRequest = new AddProductRequest();
		AddProductResponse addProductResponse = new AddProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductEntity productEntity2 = new ProductEntity();
		productEntity.setProductId(12);
		addProductRequest.setBidEndDate("2023-06-13");
		addProductRequest.setCategory("Painting");
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
		
		when(productRepository.save(productEntity2)).thenReturn(productEntity);
		addProductResponse = sellerServiceImpl.addProduct(addProductRequest);
		assertNotNull(addProductResponse);
	}
	
	@Test
	void addProduct4Test() {
		AddProductRequest addProductRequest = new AddProductRequest();
		AddProductResponse addProductResponse = new AddProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductEntity productEntity2 = new ProductEntity();
		productEntity.setProductId(12);
		addProductRequest.setBidEndDate("2023-06-13");
		addProductRequest.setCategory("");
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
		
		when(productRepository.save(productEntity2)).thenReturn(productEntity);
		addProductResponse = sellerServiceImpl.addProduct(addProductRequest);
		assertNotNull(addProductResponse);
	}
	
	@Test
	void addProduct5Test() {
		AddProductRequest addProductRequest = new AddProductRequest();
		AddProductResponse addProductResponse = new AddProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductEntity productEntity2 = new ProductEntity();
		productEntity.setProductId(12);
		addProductRequest.setBidEndDate("2020-06-13");
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
		
		when(productRepository.save(productEntity2)).thenReturn(productEntity);
		addProductResponse = sellerServiceImpl.addProduct(addProductRequest);
		assertNotNull(addProductResponse);
	}
	
	@Test
	void addProduct6Test() {
		AddProductRequest addProductRequest = new AddProductRequest();
		AddProductResponse addProductResponse = new AddProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductEntity productEntity2 = new ProductEntity();
		productEntity.setProductId(12);
		addProductRequest.setBidEndDate("2hjdj3");
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
		
		when(productRepository.save(productEntity2)).thenReturn(productEntity);
		addProductResponse = sellerServiceImpl.addProduct(addProductRequest);
		assertNotNull(addProductResponse);
	}
	
	@Test
	void findBidingDetailTest() {
		BuyerEntity buyerEntity = new BuyerEntity();
		List<BuyerEntity> buyerEntityDetail = new ArrayList<>();
		List<BidingDetails> bidingList = new ArrayList<>();
		Integer productId = 12;
		buyerEntity.setBuyerEmbedded(new BuyerEmbedded());
		buyerEntityDetail.add(buyerEntity);
		when(buyerRepository.findBidingDetail(productId)).thenReturn(buyerEntityDetail);
		bidingList = sellerServiceImpl.findBidingDetail(productId);
		assertNotNull(bidingList);
	}
	
	@Test
	void deleteProductTest() {
		ProductEntity productEntity = new ProductEntity();
		AddProductResponse addProductResponse = new AddProductResponse();
		Optional<ProductEntity> optional = Optional.of(productEntity);
		Integer productId = 12;
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2023-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		when(productRepository.findById(productId)).thenReturn(optional);
		addProductResponse = sellerServiceImpl.deleteProduct(productId);
		assertNotNull(addProductResponse);
	}
	
	@Test
	void deleteProduct2Test() {
		ProductEntity productEntity = new ProductEntity();
		AddProductResponse addProductResponse = new AddProductResponse();
		Optional<ProductEntity> optional = Optional.of(productEntity);
		Integer productId = 12;
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		when(productRepository.findById(productId)).thenReturn(optional);
		addProductResponse = sellerServiceImpl.deleteProduct(productId);
		assertNotNull(addProductResponse);
	}
	
	@Test
	void deleteProduct3Test() {
		ProductEntity productEntity = new ProductEntity();
		AddProductResponse addProductResponse = new AddProductResponse();
		List<BuyerEntity> buyerEntitylist = new ArrayList<>();
		
		Optional<ProductEntity> optional = Optional.of(productEntity);
		Integer productId = 12;
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		when(buyerRepository.findBidingDetail(productId)).thenReturn(buyerEntitylist);
		addProductResponse = sellerServiceImpl.deleteProduct(productId);
		assertNotNull(addProductResponse);
	}
	@Test
	void deleteProduct4Test() {
		ProductEntity productEntity = new ProductEntity();
		AddProductResponse addProductResponse = new AddProductResponse();
		List<BuyerEntity> buyerEntitylist = new ArrayList<>();
		buyerEntitylist.add(new BuyerEntity());
		Optional<ProductEntity> optional = Optional.of(productEntity);
		Integer productId = 12;
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-06-13");
		} catch (ParseException e) {
		}
		productEntity.setBidEndDate(new Date(utilDate.getTime()));
		when(buyerRepository.findBidingDetail(productId)).thenReturn(buyerEntitylist);
		addProductResponse = sellerServiceImpl.deleteProduct(productId);
		assertNotNull(addProductResponse);
	}
	

}
