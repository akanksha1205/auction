package com.auction.seller.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import com.auction.seller.entity.BuyerEntity;
import com.auction.seller.entity.Category;
import com.auction.seller.entity.ProductEntity;
import com.auction.seller.model.AddProductRequest;
import com.auction.seller.model.AddProductResponse;
import com.auction.seller.model.BidingDetailResponse;
import com.auction.seller.model.BidingDetails;

import com.auction.seller.repository.BuyerRepository;
import com.auction.seller.repository.ProductRepository;


@Service
@Transactional
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BuyerRepository buyerRepository;
	
	@Override
	public AddProductResponse addProduct(AddProductRequest addProductRequest) {
		AddProductResponse addProductResponse = new AddProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductEntity productEntity2 = new ProductEntity();
		productEntity.setProductName(addProductRequest.getProductName());
		productEntity.setShortDescription(addProductRequest.getShortDescription());
		productEntity.setDetailedDescription(addProductRequest.getDetailedDescription());
	
		switch (addProductRequest.getCategory()) {
		case "Painting": 
			productEntity.setCategory(Category.Painting);
			break;
		case "Sculptor":
			productEntity.setCategory(Category.Sculptor);
			break;
		case "Ornament":
			productEntity.setCategory(Category.Ornament);
			break;
		default :
			addProductResponse.setErrorMsg("Category not available");
			return addProductResponse;
		}
		
		productEntity.setStartingPrice(addProductRequest.getStartingPrice());
		Date utilDate = new Date();
		Date currDate = new Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(addProductRequest.getBidEndDate());
		} catch (ParseException e1) {
			addProductResponse.setErrorMsg(e1.getMessage());
			return addProductResponse;
		}
		if(currDate.after(utilDate)) {
			addProductResponse.setErrorMsg("Bid End Date must be a future date");
			return addProductResponse;
		}
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		productEntity.setBidEndDate(sqlDate);
		productEntity.setSellerFirstName(addProductRequest.getSellerFirstName());
		productEntity.setSellerLastName(addProductRequest.getSellerLastName());
		productEntity.setSellerEmail(addProductRequest.getSellerEmail());
		productEntity.setSellerPhone(addProductRequest.getSellerPhone());
		productEntity.setSellerAddress(addProductRequest.getSellerAddress());
		productEntity.setSellerCity(addProductRequest.getSellerCity());
		productEntity.setSellerState(addProductRequest.getSellerState());
		productEntity.setSellerPin(addProductRequest.getSellerPin());
		
		
		try {
			productEntity2 = productRepository.save(productEntity);
		} catch (Exception e) {
			addProductResponse.setErrorMsg(e.getMessage());
			return addProductResponse;
		}
		if(productEntity2!=null) {
			addProductResponse.setSuccessMsg("Product Added Successfully with product id = "+productEntity2.getProductId());
		}
		else {
			addProductResponse.setErrorMsg("Product cannot be saved");
		}
			
		return addProductResponse;
	}

	@Override
	public List<BidingDetails> findBidingDetail(Integer productId) {
		BidingDetailResponse bidingDetailResponse = new BidingDetailResponse();
		List<BuyerEntity> buyerEntityDetail = buyerRepository.findBidingDetail(productId);
		
		List<BidingDetails> bidingList = new ArrayList<>();

		for(BuyerEntity b: buyerEntityDetail) {
			BidingDetails bidingDetailsResponse = new BidingDetails();
			bidingDetailsResponse.setFirstName(b.getFirstName());
			bidingDetailsResponse.setLastName(b.getLastName());
			bidingDetailsResponse.setEmailId(b.getBuyerEmbedded().getEmailId());
			bidingDetailsResponse.setPhone(b.getPhone());
			bidingDetailsResponse.setBidAmount(b.getBidAmount());
			
			bidingList.add(bidingDetailsResponse);
			
		}
	
		return bidingList;
	}

	@Override
	public AddProductResponse deleteProduct(Integer productId) {
		AddProductResponse addProductResponse = new AddProductResponse();
		ProductEntity productEntity = new ProductEntity();
	
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");		
		Optional<ProductEntity> optional = productRepository.findById(productId);
		if(!optional.isPresent()) {
			addProductResponse.setErrorMsg("Product Id not present");
			return addProductResponse;
		}
		productEntity = optional.get();
		java.sql.Date sqlDate = productEntity.getBidEndDate();
		Date date = new Date(sqlDate.getTime());		
		
		Date currDate = new Date();
		if(currDate.after(date)) {
			addProductResponse.setErrorMsg("This product cannot be deleted");
			return addProductResponse;
		}
		
		List<BuyerEntity> buyerEntitylist = buyerRepository.findBidingDetail(productId);
		if(!buyerEntitylist.isEmpty()) {
			addProductResponse.setErrorMsg("This product cannot be deleted");
			return addProductResponse;
		}
		
		Optional<ProductEntity> optional2 = productRepository.findById(productId);
		
		if(optional2.isEmpty()) {
			addProductResponse.setErrorMsg("Product Id is not present");	
			return addProductResponse;
		}
		productEntity = optional2.get();
		productRepository.deleteById(productId);
		addProductResponse.setSuccessMsg("Successfully Deleted");
		return addProductResponse;
	}

	
}
