package com.auction.seller.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;

//import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
public class AddProductRequest {
	
	@NotNull
	@Size(min=5, message="Product name should be greater than 5")
	@Size(max=30, message="Product name should be less than 30")
	@JsonProperty("productName")
	private String productName;
	
	@JsonProperty("shortDescription")
	private String shortDescription;
	
	@JsonProperty("detailedDescription")
	private String detailedDescription;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("startingPrice")
	@Pattern(regexp = "(^[0-9]*$)", message = "Starting price should be number")
	private String startingPrice;
	

	@JsonProperty("bidEndDate")
	@NotNull(message = "Date cannot be null")
	private String bidEndDate;
	
	@NotNull
	@Size(min=5, message="First name should be greater than 5")
	@Size(max=30, message="First name should be less than 30")
	@JsonProperty("sellerFirstName")
	private String sellerFirstName;
	
	@NotNull
	@Size(min=3, message="Last name should be greater than 3")
	@Size(max=25, message="Last name should be less than 25")
	@JsonProperty("sellerLastName")
	private String sellerLastName;
	
	@JsonProperty("sellerAddress")
	private String sellerAddress;
	
	@JsonProperty("sellerCity")
	private String sellerCity;
	
	@JsonProperty("sellerState")
	private String sellerState;
	
	@JsonProperty("sellerPin")
	private String sellerPin;
	
	@NotNull
	@Size(min=10, message="Phone number should be of 10 digit")
	@Size(max=10, message="Phone number should be of 10 digit")
	@Pattern(regexp="(^$|[0-9]{10})")
	@JsonProperty("sellerPhone")
	private String sellerPhone;
	
	@NotNull
	@Email
	@Pattern(regexp="(^[a-zA-Z0-9+_.-]+@[a-zA-Z.-]+$)", message = "Invalid Email Address")
	@JsonProperty("sellerEmail")
	private String sellerEmail;
	
	

	public String getSellerFirstName() {
		return sellerFirstName;
	}

	public void setSellerFirstName(String sellerFirstName) {
		this.sellerFirstName = sellerFirstName;
	}

	public String getSellerLastName() {
		return sellerLastName;
	}

	public void setSellerLastName(String sellerLastName) {
		this.sellerLastName = sellerLastName;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerCity() {
		return sellerCity;
	}

	public void setSellerCity(String sellerCity) {
		this.sellerCity = sellerCity;
	}

	public String getSellerState() {
		return sellerState;
	}

	public void setSellerState(String sellerState) {
		this.sellerState = sellerState;
	}

	public String getSellerPin() {
		return sellerPin;
	}

	public void setSellerPin(String sellerPin) {
		this.sellerPin = sellerPin;
	}

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(String startingPrice) {
		this.startingPrice = startingPrice;
	}

	public String getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(String bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	
	
}
