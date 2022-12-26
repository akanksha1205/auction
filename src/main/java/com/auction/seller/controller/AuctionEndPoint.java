package com.auction.seller.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.seller.model.AddProductRequest;
import com.auction.seller.model.AddProductResponse;
import com.auction.seller.model.BidingDetailResponse;
import com.auction.seller.model.BidingDetails;
import com.auction.seller.service.SellerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/eauction/api/v1/seller")
public class AuctionEndPoint {

	@Autowired
	SellerService sellerService;
	
	@PostMapping("/addproduct")
	public ResponseEntity<AddProductResponse> addProduct(@RequestBody @Valid AddProductRequest addProductRequest){
		AddProductResponse addProductResponse = new AddProductResponse();
		addProductResponse = sellerService.addProduct(addProductRequest);
		return new ResponseEntity<AddProductResponse>(addProductResponse,HttpStatus.OK);
	}
	
	@GetMapping("/showbids/{productId}")
	public ResponseEntity<BidingDetailResponse> bidingDetails(@PathVariable("productId") Integer productId){
		BidingDetailResponse bidingDetailResponse = new BidingDetailResponse();
		List<BidingDetails> bidingDetail = sellerService.findBidingDetail(productId);
		if(bidingDetail.isEmpty()) {
			bidingDetailResponse.setErrorMsg("Product Id not present");
			return new ResponseEntity<BidingDetailResponse>(bidingDetailResponse, HttpStatus.OK);
		}
		bidingDetailResponse.setBidingDetails(bidingDetail);
		return new ResponseEntity<BidingDetailResponse>(bidingDetailResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<AddProductResponse> deleteProduct(@PathVariable("productId") Integer productId){
		AddProductResponse addProductResponse = new AddProductResponse();
		addProductResponse = sellerService.deleteProduct(productId);
		return new ResponseEntity<AddProductResponse>(addProductResponse, HttpStatus.OK);
	}
	
}
