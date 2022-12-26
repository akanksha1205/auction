package com.auction.buyer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auction.buyer.model.BidingRequest;
import com.auction.buyer.model.BidingResponse;
import com.auction.buyer.service.BuyerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/eauction/api/v1/buyer")
public class BidingController {
	
	@Autowired
	BuyerService buyerService;
	
	@PostMapping("/placebid")
	public ResponseEntity<BidingResponse> bidProduct(@RequestBody @Valid BidingRequest bidingRequest){
		BidingResponse bidingResponse = new BidingResponse();
		bidingResponse = buyerService.bidProduct(bidingRequest);
		return new ResponseEntity<BidingResponse>(bidingResponse, HttpStatus.OK);
	}

	@GetMapping("/updatebid/{productId}/{buyerEmailld}/{newBidAmount}")
	public ResponseEntity<BidingResponse> updateProduct(@PathVariable("productId") Integer productId, @PathVariable("buyerEmailld") String emailId, @PathVariable("newBidAmount") Integer newBidAmount){
		BidingResponse bidingResponse = new BidingResponse();
		bidingResponse = buyerService.updateProduct(productId, emailId, newBidAmount);
		return new ResponseEntity<BidingResponse>(bidingResponse, HttpStatus.OK);
	}
}
